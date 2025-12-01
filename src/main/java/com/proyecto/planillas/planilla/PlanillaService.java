package com.proyecto.planillas.planilla;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlanillaService {

private final PlanillaRepository planillaRepository;
private final PlanillaMapper planillaMapper;

public List<PlanillaViewDTO> getAllPlanillas() {
    return planillaRepository.findAll().stream().map(planillaMapper::toDto).toList();
}

public PlanillaViewDTO getPlanillaById(Long id) {
    return planillaMapper.toDto(planillaRepository.findById(id).orElseThrow());
}

//Estado de la planilla: Pendiente, Pagada, Anulada

public PlanillaViewDTO estadoPlanilla (Long id, String estado) {
    Planilla planilla = planillaRepository.findById(id).orElseThrow();
    planilla.setEstado(PlanillaEstado.PENDIENTE);
    return planillaMapper.toDto(planillaRepository.save(planilla));
}
//Cambiar estado de la planilla
public PlanillaViewDTO cambiarEstadoPlanilla (Long id, String estado) {
    Planilla planilla = planillaRepository.findById(id).orElseThrow();
    planilla.setEstado(PlanillaEstado.valueOf(estado));
    return planillaMapper.toDto(planillaRepository.save(planilla));

}



//
}
