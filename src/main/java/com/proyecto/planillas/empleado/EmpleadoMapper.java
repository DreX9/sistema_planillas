package com.proyecto.planillas.empleado;

import org.springframework.stereotype.Component;

import com.proyecto.planillas.area.Area;
import com.proyecto.planillas.cargo.Cargo;
import com.proyecto.planillas.common.MapperInterface;
import com.proyecto.planillas.horario.Horario;

@Component
public class EmpleadoMapper implements MapperInterface<Empleado, EmpleadoWriteDTO, EmpleadoViewDTO> {

    @Override
    public EmpleadoViewDTO toDto(Empleado entity) {
        return new EmpleadoViewDTO(
                entity.getId(),
                entity.getNombre(),
                entity.getApellido(),
                entity.getTelefono(),
                entity.getCorreo(),
                entity.getTipoDocumento(),
                entity.getNumeroDocumento(),
                entity.getFechaContratacion(),
                entity.getEstado(),
                entity.getSalarioBase(),
                entity.getRol().getNombre(),
                entity.getHorario().getTurnos(),
                entity.getArea().getNombre()

            );
    }

    @Override
    public Empleado toEntity(EmpleadoWriteDTO dto) {
        return Empleado.builder()
        .id(dto.id())
        .nombre(dto.nombre())
        .apellido(dto.apellido())
        .telefono(dto.telefono())
        .correo(dto.correo())
        .tipoDocumento(dto.tipoDocumento())
        .numeroDocumento(dto.numeroDocumento())
        .estado(dto.estado())
        .salarioBase(dto.salarioBase())
        .rol(Cargo.builder().id(dto.rolId()).build())
        .horario(Horario.builder().id(dto.horarioId()).build())
        .area(Area.builder().id(dto.areaId()).build())
        .build();
    }

}
