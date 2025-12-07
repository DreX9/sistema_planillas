package com.proyecto.planillas.empleado;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.proyecto.planillas.area.Area;
import com.proyecto.planillas.cargo.Cargo;
import com.proyecto.planillas.horario.Horario;

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
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleado", nullable = false, length = 10)
    private Long id;
    @Column(name = "nombre", nullable = false, length = 10)
    private String nombre;
    @Column(name = "apellido", nullable = false, length = 10)
    private String apellido;
    @Column(name = "telefono", length = 20)
    private String telefono;

    @Column(name = "correo", length = 100)
    private String correo;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_documento", length = 20, nullable = false)
    private EmpleadoTIpoDocumento tipoDocumento; 

    @Column(name = "numero_documento", length = 20, nullable = false, unique = true)
    private String numeroDocumento;

    @Column(name = "fecha_contratacion", nullable = false, updatable = false)
    private LocalDate fechaContratacion;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", length = 20, nullable = false)
    private EmpleadoEstado estado; 

    @Column(name = "salario_base", precision = 10, scale = 2, nullable = false)
    private BigDecimal salarioBase;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "cargo_id", nullable = false)
    private Cargo rol;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "horario_id", nullable = false)
    private Horario horario;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "area_id", nullable = false)
    private Area area;

    @PrePersist
    public void prePersist() {
        this.fechaContratacion = LocalDate.now();
    }

}
