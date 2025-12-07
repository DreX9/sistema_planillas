package com.proyecto.planillas.empleado;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record EmpleadoWriteDTO(
        Long id,
        @NotBlank(message = "El nombre del empleado no puede estar vacío") @Size(max = 50, message = "El nombre no puede superar los 50 caracteres") String nombre,
        @NotBlank(message = "El apellido del empleado no puede estar vacío") @Size(max = 50, message = "El apellido no puede superar los 50 caracteres") String apellido,
        @Size(max = 20, message = "El teléfono no puede superar los 20 caracteres") String telefono,

        @Email(message = "Debe ingresar un correo válido") @Size(max = 100, message = "El correo no puede superar los 100 caracteres") String correo,

         @JsonProperty("tipo_documento") @NotNull(message = "El tipo de documento es obligatorio") EmpleadoTIpoDocumento tipoDocumento,

        @JsonProperty("numero_documento") @NotBlank(message = "El número de documento es obligatorio") @Size(max = 20, message = "El número de documento no puede superar los 20 caracteres") String numeroDocumento,

        @NotNull(message = "El estado del empleado es obligatorio") EmpleadoEstado estado,

        @JsonProperty("salario_base") @NotNull(message = "El salario base es obligatorio") @DecimalMin(value = "0.00", message = "El salario no puede ser negativo") BigDecimal salarioBase,
        Long rolId,
        Long horarioId,
        Long areaId) {

}
