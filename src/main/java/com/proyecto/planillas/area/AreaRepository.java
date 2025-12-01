package com.proyecto.planillas.area;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AreaRepository extends JpaRepository<Area, Long> {
        Optional<Area> findByNombre(String nombre);
    Optional<Area> findByEstado(AreaEstado estado);
}
