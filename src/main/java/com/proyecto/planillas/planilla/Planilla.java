package com.proyecto.planillas.planilla;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
@Entity
@Data
public class Planilla {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "planilla_id")
    private Long id;
    @Column(name = "estado_planilla", nullable = false)
    private PlanillaEstado estado;


    

}
