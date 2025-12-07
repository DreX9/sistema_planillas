package com.proyecto.planillas.planilla;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("planilla")
@RequiredArgsConstructor
public class PlanillaRestController {
    private final PlanillaService planillaService;

    // ------------------------------------------------------
    // LISTAR TODO
    // ------------------------------------------------------
    @GetMapping
    public ResponseEntity<List<PlanillaViewDTO>> getAll() {
        return ResponseEntity.ok(planillaService.getAll());
    }

    // ------------------------------------------------------
    // OBTENER POR ID
    // ------------------------------------------------------
    @GetMapping("/{id}")
    public ResponseEntity<PlanillaViewDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(planillaService.getById(id));
    }

    // ------------------------------------------------------
    // GENERAR PLANILLA
    // ------------------------------------------------------
    @PostMapping("/generar")
    public ResponseEntity<PlanillaViewDTO> generar(
            @RequestParam Long empleadoId,
            @RequestParam int mes,
            @RequestParam int anio) {
        return ResponseEntity.ok(planillaService.generar(empleadoId, mes, anio));
    }

    // ------------------------------------------------------
    // CAMBIAR ESTADO
    // ------------------------------------------------------
    @PutMapping("/{id}/estado")
    public ResponseEntity<PlanillaViewDTO> cambiarEstado(
            @PathVariable Long id,
            @RequestParam String estado) {
        return ResponseEntity.ok(planillaService.cambiarEstadoPlanilla(id, estado));
    }

    // ------------------------------------------------------
    // MANEJO BÁSICO DE ERRORES (Opcional pero recomendado)
    // ------------------------------------------------------
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntime(RuntimeException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
    //rest para generar masivamente 
    @PostMapping("/generar-masivo")
    public ResponseEntity<String> generarMasivo(
            @RequestParam int mes,
            @RequestParam int anio) {
        planillaService.generarMasivo(mes, anio);
        return ResponseEntity.ok("Planillas generadas correctamente");
    }

}
