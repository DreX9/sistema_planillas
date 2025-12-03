package com.proyecto.planillas.area;

import org.springframework.stereotype.Component;

import com.proyecto.planillas.common.MapperInterface;
import com.proyecto.planillas.empresa.Empresa;

@Component
public class AreaMapper implements MapperInterface<Area, AreaWriteDTO, AreaViewDTO> {

    @Override
    public AreaViewDTO toDto(Area entity) {
        return new AreaViewDTO(
                entity.getId(),
                entity.getNombre(),
                entity.getEstado(),
                entity.getFechaCreacion(),
                entity.getEmpresa().getNombre());
    }

     
    @Override
    public Area toEntity(AreaWriteDTO dto) {
        return Area.builder()
                .id(dto.id())
                .nombre(dto.nombre())
                .estado(dto.estado())
                .empresa(Empresa.builder().id(dto.empresaId()).build())
                .build();
    }

}
