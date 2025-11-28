package com.proyecto.planillas.asistencia;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

// @RestController
// @RequestMapping("horario")
@RequiredArgsConstructor
public class AsistenciaRestController {
    /*
    private final AsistenciaService asistenciaService;
    //lISTADO DE ASISTENCIAS
    @GetMapping
    public ResponseEntity<List<AsistenciaViewDTO>> list() {
        List<AsistenciaViewDTO> list = asistenciaService.getAllAsistencias();
        return ResponseEntity.ok(list);
    }
    //Listado de ASISTENCIA POR ID
    @GetMapping("{id}")
    public ResponseEntity<AsistenciaViewDTO> getById(Long id){
        try {
            return ResponseEntity.ok(asistenciaService.getAsistenciaById(id));
        } catch (Exception e) {
            return ResponseEntity.status(Response.SC_NOT_FOUND).build();
        }
    }
    //Servicio para crear ASISTENCIA
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AsistenciaViewDTO> insertAsistencia(AsistenciaWriteDTO asistencia){
        try {
            return ResponseEntity.ok(asistenciaService.addAsistencia(asistencia));
        } catch (Exception e) {
            return ResponseEntity.status(Response.SC_INTERNAL_SERVER_ERROR).build();
        }
    }
    //Servicio para actualizar ASISTENCIA
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AsistenciaViewDTO> updateAsistencia(AsistenciaWriteDTO asistencia){
        try {
            return ResponseEntity.ok(asistenciaService.updateAsistencia(asistencia));
        } catch (Exception e) {
            return ResponseEntity.status(Response.SC_INTERNAL_SERVER_ERROR).build();
        }
    }
    //Servicio para eliminar ASISTENCIA
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteAsistencia(Long id){
        try {
            asistenciaService.deleteAsistenciaById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(Response.SC_INTERNAL_SERVER_ERROR).build();
        }
    }
*/
}
