package com.proyecto.planillas.common;

public interface MapperInterface <E, W, V>{
    V toDto(E entity);
    E toEntity(W dto);
}

