package com.proyecto.planillas.usuario;


import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UsuarioWrite(
    Long id,

    @NotBlank(message = "El usuario es un campo obligatorio.")
    @Size(max=50, message = "El nombre no puede tener más de 50 caracteres.")
    @JsonProperty("user")
    String user,

    @NotBlank(message = "La contraseña es obligatoria.")
    @JsonProperty("password")
    String password
) {
} 