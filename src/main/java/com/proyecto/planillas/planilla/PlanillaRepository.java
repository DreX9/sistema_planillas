package com.proyecto.planillas.planilla;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanillaRepository extends JpaRepository<Planilla, Long> {
    List<Planilla> findByEmpleadoIdAndMesAndAnio(Long empleadoId, Integer mes, Integer anio);
    boolean existsByEmpleadoIdAndMesAndAnio(Long empleadoId, Integer mes, Integer anio);

}
