package com.proyecto.planillas.asistencia;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AsistenciaRepository extends JpaRepository<Asistencia, Long>{
List<Asistencia> findByEmpleadoId_IdAndFechaRegistroBetween(
        Long empleadoId,
        LocalDate inicio,
        LocalDate fin
);

    
}
