package com.proyecto.planillas.asistencia;

public record AsistenciaWriteDTO(

    Long empleadoId,
    String descripcion,
    AsistenciaEstado estado
    
) {

}
