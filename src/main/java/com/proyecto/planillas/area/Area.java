package com.proyecto.planillas.area;

import java.time.LocalDate;

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
public class Area {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "area_id")
    private Long id;
    @Column(name = "area_nombre", nullable = false, length = 50, unique = true)
    private String nombre;
    @Column(name = "area_estado", nullable = false, length = 10)
    private AreaEstado estado;
    //Por verificar formato de fecha
    @Column(name = "area_fecha_creacion", nullable = false)
    private LocalDate fechaCreacion = LocalDate.now();
}
