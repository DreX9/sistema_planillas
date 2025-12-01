package com.proyecto.planillas.empleado;
import com.fasterxml.jackson.annotation.JsonProperty;

public record EmpleadoViewDTO(
        Long id,
        String nombre,
        String apellido,

        Long rolid,
        @JsonProperty("nombre_rol")
        String nombrerol,
        Long horarioId,
        @JsonProperty("turno_horario")
        String turnos,
        Long areaid,
        @JsonProperty("nombre_area")
        String nombreArea

) {

}
