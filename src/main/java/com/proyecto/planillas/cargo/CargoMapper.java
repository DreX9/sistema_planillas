package com.proyecto.planillas.cargo;

import org.springframework.stereotype.Component;

import com.proyecto.planillas.common.MapperInterface;

//@Component permite trabajar con una interfaz
@Component
public class CargoMapper implements MapperInterface <Cargo, CargoWrite, CargoView> {

    @Override
    public CargoView toDto(Cargo entity) {
        return new CargoView(
            entity.getId(),
            entity.getNombre(),
            entity.getDescripcion()
        );
    }

    @Override
    public Cargo toEntity(CargoWrite dto) {
        
        return Cargo.builder()
        .id(dto.id())
        .nombre(dto.nombre())
        .descripcion(dto.descripcion())
        .build();
    }
}
