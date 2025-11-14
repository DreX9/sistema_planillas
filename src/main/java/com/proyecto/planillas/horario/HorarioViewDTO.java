package com.proyecto.planillas.horario;

import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public record HorarioViewDTO(
    Long id,
    @JsonFormat(pattern = "HH:mm")
     LocalTime horaEntrada,
    @JsonFormat(pattern = "HH:mm")
    LocalTime horaSalida,
    String horarioDias,
    HorarioTurno turnos

) {

}
