package com.proyecto.planillas.asistencia;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public record AsistenciaViewDTO(
    Long id,
    @JsonFormat(pattern = "HH:mm")
    @JsonProperty("hora_entrada")
    LocalTime horaInicio,
    @JsonFormat(pattern = "HH:mm")
    @JsonProperty("hora_entrada")
    LocalTime horaFinal,
    @JsonProperty("fecha_registro")
    LocalDate fechaRegistro,
    AsistenciaEstado estado,
    String descripcion

) {

}
