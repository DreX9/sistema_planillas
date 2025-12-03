package com.proyecto.planillas.asistencia;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public record AsistenciaWriteDTO(

    Long empleadoId,
    String descripcion
    
) {

}
