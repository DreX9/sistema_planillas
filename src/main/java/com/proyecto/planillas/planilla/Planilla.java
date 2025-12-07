package com.proyecto.planillas.planilla;

import java.math.BigDecimal;
import java.time.LocalDate;

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
public class Planilla {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "empleado_id")
    private Empleado empleado;

    @Column(nullable = false, updatable = false)
    private LocalDate fechaGeneracion;

    @Column(nullable = false)
    private BigDecimal sueldoBase;

    @Column(nullable = false)
    private BigDecimal totalDescuentos;

    @Column(nullable = false)
    private BigDecimal sueldoNeto;

    @Column(nullable = false)
    private Integer diasTrabajados;

    @Column(nullable = false)
    private Integer tardanzas;

    @Column(nullable = false)
    private Integer inasistencias;

    @Column(nullable = false)
    private Integer mes;

    @Column(nullable = false)
    private Integer anio;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PlanillaEstado estado;
}
