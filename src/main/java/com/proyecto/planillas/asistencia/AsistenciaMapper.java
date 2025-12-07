package com.proyecto.planillas.asistencia;

import org.springframework.stereotype.Component;

import com.proyecto.planillas.common.MapperInterface;
import com.proyecto.planillas.empleado.Empleado;

@Component

public class AsistenciaMapper implements MapperInterface<Asistencia, AsistenciaWriteDTO, AsistenciaViewDTO> {

    @Override
    public AsistenciaViewDTO toDto(Asistencia entity) {
        return new AsistenciaViewDTO(
            entity.getId(),
            entity.getHoraInicio(),
            entity.getHoraFinal(),
            entity.getFechaRegistro(),
            entity.getEstado(),
            entity.getDescripcion(),
            entity.getEmpleadoId().getNombre()
        );
    }

    @Override
    public Asistencia toEntity(AsistenciaWriteDTO dto) {
        return Asistencia.builder()
            .descripcion(dto.descripcion())
            .empleadoId(Empleado.builder().id(dto.empleadoId()).build())
            .estado(dto.estado())
            .build();
    }
    


}
