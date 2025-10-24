package com.proyecto.planillas.area;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AreaWriteDTO( 
        Long id,
        @NotBlank(message = "El nombre del área no puede estar vacío")
        @Size(max = 50, message = "El nombre no puede superar los 50 caracteres")
        @JsonProperty("nombre")
        String nombre,
        @Enumerated(EnumType.STRING)
        @JsonProperty("estado") 
        AreaEstado estado,
        @JsonProperty("fecha_creacion")
        LocalDate fechaCreacion 
    ) {

}
