package com.proyecto.planillas.area;

import org.springframework.stereotype.Component;

import com.proyecto.planillas.common.MapperInterface;

@Component
public class AreaMapper implements MapperInterface<Area, AreaWriteDTO, AreaViewDTO> {

    @Override
    public AreaViewDTO toDto(Area entity) {
        return new AreaViewDTO(
                entity.getId(),
                entity.getNombre(),
                entity.getEstado());
    }

     
    @Override
    public Area toEntity(AreaWriteDTO dto) {
        return Area.builder()
                .id(dto.id())
                .nombre(dto.nombre())
                .estado(dto.estado())
                .build();
    }

}
