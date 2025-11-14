package com.proyecto.planillas.horario;


import org.springframework.stereotype.Component;

import com.proyecto.planillas.common.MapperInterface;
import com.proyecto.planillas.dias.HorarioDias;

@Component
public class HorarioMapper implements MapperInterface<Horario, HorarioWriteDTO, HorarioViewDTO> {

    @Override
    public HorarioViewDTO toDto(Horario entity) {
        return new HorarioViewDTO(
            entity.getId(),
            entity.getHoraEntrada(),
            entity.getHoraSalida(),
            entity.getHorarioDias().getDia(), 
            entity.getTurnos()
        );
    }

    @Override
    public Horario toEntity(HorarioWriteDTO dto) {
        return Horario.builder()
                .id(dto.id())
                .horaEntrada(dto.horaEntrada())
                .horaSalida(dto.horaSalida())
                .horarioDias(HorarioDias.builder().id(dto.horarioDiasId()).build())
                .turnos(dto.turnos())
                .build();
    }

}
