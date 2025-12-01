package com.proyecto.planillas.asistencia;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;

public record AsistenciaWriteDTO(

    Long id,
    // @NotNull(message = "La hora de entrada no puede ser nula") 
    @JsonFormat(pattern = "HH:mm") @JsonProperty("hora_inicio")
    LocalTime horaInicio,
    // @NotNull(message = "La hora de entrada no puede ser nula") 
    @JsonFormat(pattern = "HH:mm") @JsonProperty("hora_final")
    LocalTime horaFinal,
    // @NotNull(message = "La fecha de registro no puede ser nula")
    @JsonProperty("fecha_registro")
    @JsonFormat(pattern = "yyyy-MM-dd") 
    LocalDate fechaRegistro,
    @Enumerated(EnumType.STRING)
    AsistenciaEstado estado,
    String descripcion,
    Long empleadoId
    
) {

}
