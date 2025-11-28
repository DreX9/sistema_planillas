package com.proyecto.planillas.asistencia;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Asistencia {
    // @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "asistencia_id")
    private Long id;
    @Column(name = "hora_inicio", nullable = false)
    private LocalTime horaInicio;
    @Column(name = "hora_final", nullable = false)
    private LocalTime horaFinal;
    @Column(name = "fecha_registro", nullable = false)
    private LocalDate fechaRegistro;
    @Column(name = "estado_asistencia", nullable = false)
    private AsistenciaEstado estado;
    @Column(name = "descripcion", length = 100, nullable = false)
    private String descripcion;
}
