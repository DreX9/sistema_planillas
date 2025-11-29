package com.proyecto.planillas.usuario;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    public Usuario getUsuarioById(Long id) {

        return usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("User ID not found"));
    }

     public Usuario getUsuarioByUser(String user) {

        return usuarioRepository.findByUser(user).orElseThrow(() -> new RuntimeException("User  Email not found"));
    }

}
