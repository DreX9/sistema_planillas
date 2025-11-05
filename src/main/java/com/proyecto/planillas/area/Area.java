package com.proyecto.planillas.area;

import java.time.LocalDate;

import com.proyecto.planillas.empresa.Empresa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
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
    @Column(name = "fecha_creacion", nullable = false, updatable = false)
    private LocalDate fechaCreacion;

    // updatable NO SE ACTUALIZA CUANDO HACES UNA MODIFICACIÓN
    @PrePersist
    public void prePersist() {
        this.fechaCreacion = LocalDate.now();
    }
    //a nivel modelo JPA, no acepta un objeto empresa = null.
    //Indica que cuando traes un Area, no cargue automáticamente los datos completos de la Empresa asociada, solo el id
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "empresa_id", nullable = false)
    private Empresa empresa;
}
