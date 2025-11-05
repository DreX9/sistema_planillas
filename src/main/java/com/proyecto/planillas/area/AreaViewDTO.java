package com.proyecto.planillas.area;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AreaViewDTO(
                Long id,
                String nombre,
                AreaEstado estado,
                @JsonProperty("fecha_creacion") LocalDate fechaCreacion,
                Long empresaId,
                @JsonProperty("nombre_empresa") String empresaNombre) {

}
