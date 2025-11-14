package com.proyecto.planillas.usuario;

import org.springframework.stereotype.Component;

import com.proyecto.planillas.common.MapperInterface;

@Component
public class UsuarioMapper implements MapperInterface <Usuario, UsuarioWrite, UsuarioView>{

    @Override
    public UsuarioView toDto(Usuario entity) {
        return new UsuarioView(
            entity.getId(),
            entity.getUser(),
            entity.getPassword()
        );
    }

    @Override
    public Usuario toEntity(UsuarioWrite dto) {
        return Usuario.builder()
        .id(dto.id())
        .user(dto.user())
        .password(dto.password())
        .build();
    }
    
}
