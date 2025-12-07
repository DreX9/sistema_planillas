package com.proyecto.planillas.planilla;

import org.springframework.stereotype.Component;

import com.proyecto.planillas.common.MapperInterface;

@Component
public class PlanillaMapper implements MapperInterface<Planilla, PlanillaWriteDTO, PlanillaViewDTO> {

    @Override
    public PlanillaViewDTO toDto(Planilla entity) {
        return new PlanillaViewDTO(
                entity.getId(),
                entity.getFechaGeneracion(),
                entity.getMes(),
                entity.getAnio(),

                entity.getEmpleado().getNombre(),
                entity.getEmpleado().getApellido(),

                entity.getSueldoBase(),
                entity.getTotalDescuentos(),
                entity.getSueldoNeto(),

                entity.getDiasTrabajados(),
                entity.getTardanzas(),
                entity.getInasistencias(),

                entity.getEstado());
    }

    @Override
    public Planilla toEntity(PlanillaWriteDTO dto) {

        return null;
    }

}
