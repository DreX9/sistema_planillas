package com.proyecto.planillas.cargo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public record CargoWrite(
    Long id,

    @NotBlank(message = "El nombre del cargo no puede estar vacío.")
    @Size(max = 50, message = "El nombre no puede tener más de 50 caracteres.")
    String nombre,

    @Size(max = 250, message = "La descripción no puede tener más de 250 caracteres.")
    String descripcion

) {
    
}
