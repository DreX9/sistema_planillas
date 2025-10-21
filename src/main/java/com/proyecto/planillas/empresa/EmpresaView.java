package com.proyecto.planillas.empresa;

import com.fasterxml.jackson.annotation.JsonProperty;

public record EmpresaView(
        Long id,
        String nombre,
        String ruc,
        @JsonProperty("razon_social") String razonSocial,
        String telefono,
        @JsonProperty("telefono_respaldo") String telefonoRespaldo,
        String correo,
        String direccion) {

}
