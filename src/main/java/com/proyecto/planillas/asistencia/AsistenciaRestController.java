package com.proyecto.planillas.asistencia;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.proyecto.planillas.area.AreaViewDTO;
import com.proyecto.planillas.area.AreaWriteDTO;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("asistencia")
@RequiredArgsConstructor
public class AsistenciaRestController {
    
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

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AsistenciaViewDTO> insertAsistencia(@Valid @RequestBody AsistenciaWriteDTO asistenciaWriteDTO){
        try {
            return ResponseEntity.ok(asistenciaService.addAsistencia(asistenciaWriteDTO));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<AsistenciaViewDTO> updateAsistencia(@RequestBody AsistenciaWriteDTO asistenciaWriteDTO){
        try {
            return ResponseEntity.ok(asistenciaService.updateAsistencia(asistenciaWriteDTO));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }     
}
