package com.proyecto.planillas.planilla;

import org.springframework.stereotype.Component;

import com.proyecto.planillas.common.MapperInterface;
@Component
public class PlanillaMapper implements MapperInterface<Planilla, PlanillaWriteDTO, PlanillaViewDTO> {

    @Override
    public PlanillaViewDTO toDto(Planilla entity) {
        return new PlanillaViewDTO(
            entity.getId(),
            entity.getEstado()
        );
    }

    @Override
    public Planilla toEntity(PlanillaWriteDTO dto) {
        Planilla planilla = new Planilla();
        planilla.setId(dto.id());
        planilla.setEstado(dto.estado());
        return planilla;
    }

}
