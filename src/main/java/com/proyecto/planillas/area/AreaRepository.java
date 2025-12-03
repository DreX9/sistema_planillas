package com.proyecto.planillas.area;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AreaRepository extends JpaRepository<Area, Long> {
        Optional<Area> findByNombre(String nombre);
    List<Area> findByEmpresaId(Long empresaId);
    List<Area> findByEstado(AreaEstado estado);
}
