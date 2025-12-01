package com.proyecto.planillas.planilla;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

 @RestController
 @RequestMapping("planillas")
 @RequiredArgsConstructor
public class PlanillaRestController {
private final PlanillaService planillaService;
@GetMapping
public ResponseEntity<List<PlanillaViewDTO>> list() {
    List<PlanillaViewDTO> list = planillaService.getAllPlanillas();
    return ResponseEntity.ok(list);

}

@GetMapping("{id}")
public ResponseEntity<PlanillaViewDTO> getById(Long id){
    try {
        return ResponseEntity.ok(planillaService.getPlanillaById(id));
    } catch (Exception e) {
        return ResponseEntity.status(Response.SC_NOT_FOUND).build();
    }

}

}
