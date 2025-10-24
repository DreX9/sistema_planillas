package com.proyecto.planillas.area;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AreaViewDTO(
        Long id,
        String nombre,
        AreaEstado estado,
        @JsonProperty("fecha_creacion") String fechaCreacion) {

}
