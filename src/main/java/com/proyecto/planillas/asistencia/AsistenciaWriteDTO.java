package com.proyecto.planillas.asistencia;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;

public record AsistenciaWriteDTO(

    Long id,
    @NotNull(message = "La hora de entrada no puede ser nula") @JsonFormat(pattern = "HH:mm") @JsonProperty("hora_inicio")
    LocalTime horaInicio,
    @NotNull(message = "La hora de entrada no puede ser nula") @JsonFormat(pattern = "HH:mm") @JsonProperty("hora_final")
    LocalTime horaFinal,
    @NotNull(message = "La fecha de registro no puede ser nula") 
    LocalDate fechaRegistro,
    @JsonProperty("estado_asistencia")
    AsistenciaEstado estado,
    @JsonProperty("descripcion")
    String descripcion

) {

}
