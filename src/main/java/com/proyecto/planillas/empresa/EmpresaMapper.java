package com.proyecto.planillas.empresa;

import org.springframework.stereotype.Component;

import com.proyecto.planillas.common.MapperInterface;
@Component
public class EmpresaMapper implements MapperInterface<Empresa, EmpresaWrite, EmpresaView>{

    @Override
    public EmpresaView toDto(Empresa entity) {
       return new EmpresaView(
                entity.getId(),
                entity.getNombre(),
                entity.getRuc(),
                entity.getTelefono(),
                entity.getTelefonoRespaldo(),
                entity.getCorreo(),
                entity.getDireccion()
       );
    }

    @Override
    public Empresa toEntity(EmpresaWrite dto) {
        return Empresa.builder()
                .id(dto.id())
                .nombre(dto.nombre())
                .ruc(dto.ruc())
                .telefono(dto.telefono())
                .telefonoRespaldo(dto.telefonoRespaldo())
                .correo(dto.correo())
                .direccion(dto.direccion())
                .build();
    }
    
}
