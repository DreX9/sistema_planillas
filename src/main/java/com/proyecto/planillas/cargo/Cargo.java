package com.proyecto.planillas.cargo;

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
@Builder
@AllArgsConstructor
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cargo_id")
    private Long id;

    @Column(nullable = false, name = "cargo_nombre", length = 50, unique = true)
    private String nombre;

    @Column(nullable = false, name = "cargo_descripcion", length = 250)
    private String descripcion;


}
