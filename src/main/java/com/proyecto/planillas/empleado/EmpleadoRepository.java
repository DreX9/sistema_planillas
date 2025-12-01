package com.proyecto.planillas.empleado;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long>{
    Optional<Empleado> findByNombre(String nombre);
}
