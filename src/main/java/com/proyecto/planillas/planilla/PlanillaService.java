package com.proyecto.planillas.planilla;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.proyecto.planillas.asistencia.Asistencia;
import com.proyecto.planillas.asistencia.AsistenciaEstado;
import com.proyecto.planillas.asistencia.AsistenciaRepository;
import com.proyecto.planillas.empleado.Empleado;
import com.proyecto.planillas.empleado.EmpleadoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlanillaService {

    private final PlanillaRepository planillaRepository;
    private final AsistenciaRepository asistenciaRepository; // <-- agregar
    private final EmpleadoRepository empleadoRepository; // <-- agregar
    private final PlanillaMapper mapper;

    // Obtener todas
    public List<PlanillaViewDTO> getAll() {
        return planillaRepository.findAll().stream()
                .map(mapper::toDto)
                .toList();
    }

    // Obtener por ID
    public PlanillaViewDTO getById(Long id) {
        return mapper.toDto(
                planillaRepository.findById(id).orElseThrow());
    }

    // -------------------------------------------------
    // GENERAR PLANILLA
    // -------------------------------------------------
    public PlanillaViewDTO generar(Long empleadoId, int mes, int anio) {

        // validar mes futuro
        LocalDate hoy = LocalDate.now();
        LocalDate periodo = LocalDate.of(anio, mes, 1);

        if (periodo.isAfter(hoy.withDayOfMonth(1))) {
            throw new RuntimeException("No se pueden generar planillas de meses futuros.");
        }

        // evitar duplicado
        if (planillaRepository.existsByEmpleadoIdAndMesAndAnio(empleadoId, mes, anio)) {
            throw new RuntimeException("La planilla ya fue generada.");
        }

        Empleado empleado = empleadoRepository.findById(empleadoId).orElseThrow();

        LocalDate inicio = LocalDate.of(anio, mes, 1);
        LocalDate fin = inicio.withDayOfMonth(inicio.lengthOfMonth());

        List<Asistencia> asistencias = asistenciaRepository.findByEmpleadoId_IdAndFechaRegistroBetween(
                empleadoId, inicio, fin);

        int diasDelMes = inicio.lengthOfMonth();

        // Regla: si no tiene asistencias, no se genera
        if (asistencias.isEmpty()) {
            throw new RuntimeException(
                    "El empleado no tiene registros de asistencia este mes. No se generó la planilla.");
        }

        int diasTrabajados = (int) asistencias.stream()
                .filter(a -> a.getEstado() == AsistenciaEstado.Puntual ||
                        a.getEstado() == AsistenciaEstado.Justificado)
                .count();

        int tardanzas = (int) asistencias.stream()
                .filter(a -> a.getEstado() == AsistenciaEstado.Tarde)
                .count();

        int inasistencias = diasDelMes - asistencias.size();

        // Regla: mínimo 15 días trabajados
        if (diasTrabajados < 15) {
            throw new RuntimeException(
                    "El empleado no cumple con los días mínimos trabajados (15). No se generó la planilla.");
        }

        BigDecimal sueldoBase = empleado.getSalarioBase();
        BigDecimal totalDescuentos = BigDecimal.valueOf(inasistencias * 20 + tardanzas * 5);
        BigDecimal sueldoNeto = sueldoBase.subtract(totalDescuentos);

        Planilla planilla = Planilla.builder()
                .empleado(empleado)
                .fechaGeneracion(LocalDate.now())
                .mes(mes)
                .anio(anio)
                .sueldoBase(sueldoBase)
                .totalDescuentos(totalDescuentos)
                .sueldoNeto(sueldoNeto)
                .diasTrabajados(diasTrabajados)
                .tardanzas(tardanzas)
                .inasistencias(inasistencias)
                .estado(PlanillaEstado.GENERADA)
                .build();

        return mapper.toDto(planillaRepository.save(planilla));
    }

    // Cambiar estado
    public PlanillaViewDTO cambiarEstadoPlanilla(Long id, String estado) {
        Planilla planilla = planillaRepository.findById(id).orElseThrow();
        planilla.setEstado(PlanillaEstado.valueOf(estado));
        return mapper.toDto(planillaRepository.save(planilla));
    }

    // ============================================
    // GENERAR MASIVO
    // ============================================
    public void generarMasivo(int mes, int anio) {

        List<Empleado> empleados = empleadoRepository.findAll();

        for (Empleado emp : empleados) {

            try {
                generar(emp.getId(), mes, anio);
            } catch (Exception ignored) {
                // si no cumple reglas, simplemente NO se genera
            }
        }
    }
}
