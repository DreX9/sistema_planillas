package com.proyecto.planillas.horario;

import java.time.LocalTime;

// 
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Horario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "horario_id")
    private Long id;
    @Column(name = "hora_entrada", nullable = false)
    private LocalTime horaEntrada;
    @Column(name = "hora_salida", nullable = false)
    private LocalTime horaSalida;
    @Column(name = "turnos", length = 50, nullable = false)
    private String turnos;
    @Column(name = "dias", length = 50, nullable = false)
    private String dias;
    
    // @ManyToOne(fetch = FetchType.LAZY)
    // private Empleado empleado;

}
