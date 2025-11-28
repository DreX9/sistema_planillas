package com.proyecto.planillas.horario;

import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;

public record HorarioWriteDTO(
        Long id,

        @NotNull(message = "La hora de entrada no puede ser nula") @JsonFormat(pattern = "HH:mm") @JsonProperty("hora_entrada") LocalTime horaEntrada,
        @NotNull(message = "La hora de salida no puede ser nula") @JsonFormat(pattern = "HH:mm") @JsonProperty("hora_salida") LocalTime horaSalida,
        String dias,
        String turnos

) {

}
