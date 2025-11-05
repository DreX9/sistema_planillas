package com.proyecto.planillas.usuario;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UsuarioView(
    Long id,
    @JsonProperty("user")
    String user,
    @JsonProperty("password")
    String password) {
}
    
