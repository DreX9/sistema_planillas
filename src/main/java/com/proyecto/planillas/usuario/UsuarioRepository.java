package com.proyecto.planillas.usuario;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository <Usuario, Long>{
    Optional<Usuario> findByUser(String user);

}
