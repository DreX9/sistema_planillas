package com.proyecto.planillas.horario;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
@RestController
@RequestMapping("horario")
@RequiredArgsConstructor
public class HorarioRestController {
    private final HorarioService horarioService;
    
    @GetMapping
    public ResponseEntity<List<HorarioViewDTO>> list() throws ResponseStatusException{
        List<HorarioViewDTO> list = horarioService.getAllHorarios();
        if (list.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT,"No data");
        }
        return ResponseEntity.ok(list);
    }

    @GetMapping("{id}")
    public ResponseEntity<HorarioViewDTO> getById(@PathVariable Long id){
        
        try {
            return ResponseEntity.ok(horarioService.getHorarioById(id));
        } catch (Exception e) {
          throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No data");
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HorarioViewDTO> insertHorario(@Valid @RequestBody HorarioWriteDTO horario){
        
        try {
            return ResponseEntity.ok(horarioService.addHorario(horario));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<HorarioViewDTO> updateHorario(@RequestBody HorarioWriteDTO horario){
        
        try {
            return ResponseEntity.ok(horarioService.updateHorario(horario));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteHorario(@PathVariable Long id){
        try {
            horarioService.deleteHorarioById(id);
            return ResponseEntity.ok(String.format("Horario eliminado por id: %d", id)); 
        } catch(Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
    // @DeleteMapping("{id}")
    // public ResponseEntity<Void> deleteHorario(@PathVariable Long id){
    //     try {
    //         horarioService.deleteHorarioById(id);
    //         return ResponseEntity.ok(String.format("Empresa eliminada por id: %d", id)); 
    //     } catch(Exception e){
    //         throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
    //     }
    // }
}
