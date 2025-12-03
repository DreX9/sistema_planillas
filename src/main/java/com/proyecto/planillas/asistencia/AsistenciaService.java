package com.proyecto.planillas.asistencia;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.proyecto.planillas.empleado.Empleado;
import com.proyecto.planillas.empleado.EmpleadoRepository;
import com.proyecto.planillas.horario.Horario;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AsistenciaService {

    private final AsistenciaRepository asistenciaRepository;
    private final EmpleadoRepository empleadoRepository;
    private final AsistenciaMapper asistenciaMapper;

    public List<AsistenciaViewDTO> getAllAsistencias() {
        return asistenciaRepository.findAll().stream().map(asistenciaMapper::toDto).toList();
    }

    public AsistenciaViewDTO getAsistenciaById(Long id) {
        return asistenciaMapper.toDto(asistenciaRepository.findById(id).orElseThrow());
    }

    @Transactional
    public AsistenciaViewDTO addAsistencia(AsistenciaWriteDTO asistencia) {
        return save(asistencia);
    }

    // @Transactional
    // public AsistenciaViewDTO updateAsistencia(AsistenciaWriteDTO asistencia) {
    // if (!asistenciaRepository.existsById(asistencia.id())) {
    // throw new IllegalStateException("Id no encotrado");
    // }

    // return save(asistencia);
    // }

    public AsistenciaViewDTO save(AsistenciaWriteDTO asistencia) {
        return asistenciaMapper.toDto(asistenciaRepository.save(asistenciaMapper.toEntity(asistencia)));
    }

    @Transactional
    public void deleteAsistenciaById(Long id) {
        try {
            asistenciaRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("ID not found" + (id));
        }

    }

    @Transactional
    public AsistenciaViewDTO registrarAsistencia(AsistenciaWriteDTO dto) {

        // 1. Obtener empleado
        Empleado empleado = empleadoRepository.findById(dto.empleadoId())
                .orElseThrow(() -> new IllegalStateException("Empleado no encontrado"));

        Horario horario = empleado.getHorario();

        LocalTime horaActual = LocalTime.now();
        LocalTime horaEntrada = horario.getHoraEntrada();
        LocalTime horaSalida = horario.getHoraSalida();

        // 2. Determinar estado (Puntual – Tarde)
        LocalTime tolerancia = horaEntrada.plusMinutes(5);

        AsistenciaEstado estado = (horaActual.isAfter(tolerancia))
                ? AsistenciaEstado.Tarde
                : AsistenciaEstado.Puntual;

        // 3. Crear la asistencia
        Asistencia asistencia = Asistencia.builder()
                .horaInicio(horaActual)
                .horaFinal(horaSalida)
                .fechaRegistro(LocalDate.now())
                .estado(estado)
                .descripcion(dto.descripcion())
                .empleadoId(empleado) // correcto
                .build();

        asistenciaRepository.save(asistencia);

        return asistenciaMapper.toDto(asistencia);
    }

}
