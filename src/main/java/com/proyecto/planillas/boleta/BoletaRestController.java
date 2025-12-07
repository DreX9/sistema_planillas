package com.proyecto.planillas.boleta;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("boleta")
@RequiredArgsConstructor
public class BoletaRestController {
    private final BoletaPdfService boletaPdfService;

    @GetMapping("/{id}/pdf")
    public ResponseEntity<byte[]> descargarBoleta(@PathVariable Long id) {

        byte[] pdf = boletaPdfService.generarBoleta(id);

        return ResponseEntity.ok()
                .header("Content-Type", "application/pdf")
                .header("Content-Disposition", "inline; filename=boleta_" + id + ".pdf")
                .body(pdf);
    }
}
