package com.proyecto.planillas.horario;

import java.time.LocalTime;

import com.proyecto.planillas.dias.HorarioDias;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
// import jakarta.persistence.PrePersist;
// import jakarta.validation.constraints.NotNull;
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
    @Column(name = "hora_entrada", nullable = false, updatable = false)
    private LocalTime horaEntrada;
    @Column(name = "hora_salida", nullable = false)
    private LocalTime horaSalida;
    // @Column(name = "dias_asignados", length = 10, nullable = false)
    // private HorarioLista diasAsignados;
    @Column(name = "turnos", length = 50)
    private HorarioTurno turnos;
    @ManyToOne
    private HorarioDias horarioDias;
    // @ManyToOne(fetch = FetchType.LAZY)
    // private Empleado empleado;

}
