package com.proyecto.planillas.asistencia;

import org.springframework.stereotype.Component;

import com.proyecto.planillas.common.MapperInterface;

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
            entity.getDescripcion()
        );
    }

    @Override
    public Asistencia toEntity(AsistenciaWriteDTO dto) {
        Asistencia asistencia = new Asistencia();
        asistencia.setId(dto.id());
        asistencia.setHoraInicio(dto.horaInicio());
        asistencia.setHoraFinal(dto.horaFinal());
        asistencia.setFechaRegistro(dto.fechaRegistro());
        asistencia.setEstado(dto.estado());
        asistencia.setDescripcion(dto.descripcion());
        return asistencia;
    }
    


}
