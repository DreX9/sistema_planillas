package com.proyecto.planillas.empresa;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record EmpresaWrite(
    Long id,

    @NotBlank(message = "El nombre de la empresa es un campo obligatorio")
    @Size(max = 100, message = "El nombre no puede tener más de 100 caracteres")
    @JsonProperty("nombre")
    String nombre,

    @NotBlank(message = "El RUC es obligatorio")
    @Pattern(regexp = "\\d{11}", message = "El RUC debe contener exactamente 11 dígitos numéricos")
    @JsonProperty("ruc")
    String ruc,

    @NotBlank(message = "La razón social es un campo obligatorio")
    @JsonProperty("razon_social")
    String razonSocial,

    @NotBlank(message = "El teléfono principal es obligatorio")
    @Pattern(regexp = "\\d{9}", message = "El teléfono debe tener exactamente 9 dígitos")
    @JsonProperty("telefono")
    String telefono,

    @NotBlank(message = "El teléfono de respaldo es obligatorio")
    @Pattern(regexp = "\\d{9}", message = "El teléfono de respaldo debe tener exactamente 9 dígitos")
    @JsonProperty("telefono_respaldo")
    String telefonoRespaldo,

    @NotBlank(message = "El correo electrónico es obligatorio")
    @Email(message = "Debe proporcionar un correo electrónico válido")
    @JsonProperty("correo")
    String correo,

    @NotBlank(message = "La dirección es un campo obligatorio")
    @JsonProperty("direccion")
    String direccion

) {
    
}
