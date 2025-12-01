package com.proyecto.planillas.horario;


import org.springframework.stereotype.Component;

import com.proyecto.planillas.common.MapperInterface;


@Component
public class HorarioMapper implements MapperInterface<Horario, HorarioWriteDTO, HorarioViewDTO> {

    @Override
    public HorarioViewDTO toDto(Horario entity) {
        return new HorarioViewDTO(
            entity.getId(),
            entity.getHoraEntrada(),
            entity.getHoraSalida(),
            entity.getDias(), 
            entity.getTurnos()
        );
    }

    @Override
    public Horario toEntity(HorarioWriteDTO dto) {
        return Horario.builder()
                .id(dto.id())
                .horaEntrada(dto.horaEntrada())
                .horaSalida(dto.horaSalida())
                .dias(dto.dias())
                .turnos(dto.turnos())
                .build();
    }
    
}
