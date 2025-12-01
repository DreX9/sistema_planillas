package com.proyecto.planillas.horario;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;



public interface HorarioRepository extends JpaRepository<Horario, Long>{
Optional<Horario> findByTurnos(String turnos);

}
