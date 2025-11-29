package com.proyecto.planillas.empleado;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record EmpleadoWriteDTO(
                Long id,
                @NotBlank(message = "El nombre del empleado no puede estar vacío") @Size(max = 50, message = "El nombre no puede superar los 50 caracteres") String nombre,
                @NotBlank(message = "El apellido del empleado no puede estar vacío") @Size(max = 50, message = "El apellido no puede superar los 50 caracteres") String apellido,
                Long rolId) {

}
