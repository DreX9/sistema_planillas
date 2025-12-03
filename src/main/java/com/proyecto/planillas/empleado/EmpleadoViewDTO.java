package com.proyecto.planillas.empleado;
import com.fasterxml.jackson.annotation.JsonProperty;

public record EmpleadoViewDTO(
        Long id,
        String nombre,
        String apellido,

        Long rolid,
        @JsonProperty("nombre_rol")
        String nombrerol,
        @JsonProperty("turno_horario")
        String turnos,
        @JsonProperty("nombre_area")
        String nombreArea

) {

}
