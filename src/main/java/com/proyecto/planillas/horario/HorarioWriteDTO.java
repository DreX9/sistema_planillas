package com.proyecto.planillas.horario;

import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;

public record HorarioWriteDTO(
        Long id,

        @NotNull(message = "La hora de entrada no puede ser nula") @JsonFormat(pattern = "HH:mm") LocalTime horaEntrada,
        @NotNull(message = "La hora de salida no puede ser nula") @JsonFormat(pattern = "HH:mm") LocalTime horaSalida,

        Long horarioDiasId,
        HorarioTurno turnos

) {
    // @AssertTrue
    // private boolean isHorasValidas() {
    // return horaSalida.isAfter(horaEntrada);
    // }

}
