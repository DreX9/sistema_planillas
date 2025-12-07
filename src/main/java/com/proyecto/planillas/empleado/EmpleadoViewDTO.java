package com.proyecto.planillas.empleado;
import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

public record EmpleadoViewDTO(
        Long id,
        String nombre,
        String apellido,

        String telefono,
        String correo,

        @JsonProperty("tipo_documento")
        EmpleadoTIpoDocumento tipoDocumento,

        @JsonProperty("numero_documento")
        String numeroDocumento,

        @JsonProperty("fecha_contratacion")
        LocalDate fechaContratacion,

        EmpleadoEstado estado,

        @JsonProperty("salario_base")
        BigDecimal salarioBase,
        @JsonProperty("nombre_rol")
        String nombrerol,
        @JsonProperty("turno_horario")
        String turnoHorario,
        @JsonProperty("nombre_area")
        String nombreArea

) {

}
