package com.proyecto.planillas.cargo;

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
@RequiredArgsConstructor
@RequestMapping("cargo")
public class CargoRestController {
    private final CargoService CargoService;
    @GetMapping
    public ResponseEntity<List<CargoView>> List()
    throws ResponseStatusException{
        List<CargoView> list= CargoService.getAllCargos();
        if (list.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT,"No data");
        }
        return ResponseEntity.ok(list);
    }
    @GetMapping("{id}")
    public ResponseEntity<CargoView> getById(@PathVariable Long id){
        try {
            return ResponseEntity.ok(CargoService.getCargosbyId(id));
        } catch (Exception e) {
            // Mandamos un vacío
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No data");
        }
    }
    
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CargoView> insertCargo(@Valid @RequestBody CargoWrite Cargos){
        
        try {
            return ResponseEntity.ok(CargoService.addCargos(Cargos));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<CargoView> update(@RequestBody CargoWrite Cargos){
        
        try {
            return ResponseEntity.ok(CargoService.updateCargo(Cargos));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
    @DeleteMapping
    public ResponseEntity<String> deleteById(@PathVariable long id){
        try {
            CargoService.deleteCargoById(id);
            return ResponseEntity.ok(String.format("Cargo eliminado con id: %c", id));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
    
}
