package com.proyecto.planillas.asistencia;

import java.time.LocalDate;
import java.time.LocalTime;
import com.proyecto.planillas.empleado.Empleado;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Asistencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "asistencia_id")
    private Long id;
    @Column(name = "hora_inicio", nullable = false)
    private LocalTime horaInicio;
    @Column(name = "hora_final", nullable = false)
    private LocalTime horaFinal;
    @Column(name = "fecha_registro", nullable = false)
    private LocalDate fechaRegistro;
    @Enumerated(EnumType.STRING)
    @Column(name = "estado_asistencia", nullable = false)
    private AsistenciaEstado estado;
    @Column(name = "descripcion", length = 100, nullable = false)
    private String descripcion;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "empleado_id", nullable = false)
    private Empleado empleadoId;
}
