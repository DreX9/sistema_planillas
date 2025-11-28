package com.proyecto.planillas.horario;

import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public record HorarioViewDTO(
    Long id,
    @JsonFormat(pattern = "HH:mm")
    @JsonProperty("hora_entrada")
     LocalTime horaEntrada,
     @JsonProperty("hora_salida")
    @JsonFormat(pattern = "HH:mm")
    LocalTime horaSalida,
    String dias,
    String turnos

) {

}
