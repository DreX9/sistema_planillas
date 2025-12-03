package com.proyecto.planillas.empresa;

import java.util.List;
import java.util.Map;

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
@RequestMapping("empresa")
@RequiredArgsConstructor
public class EmpresaRestController {
    private final EmpresaService empresaService;
    
    @GetMapping
    public ResponseEntity<List<EmpresaView>> list() throws ResponseStatusException{
        List<EmpresaView> list = empresaService.getAllEmpresas();
        if (list.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT,"No data");
        }
        return ResponseEntity.ok(list);
    }
    @GetMapping("{id}")
    public ResponseEntity<EmpresaView> getById(@PathVariable Long id){
        
        try {
            return ResponseEntity.ok(empresaService.getEmpresasById(id));
        } catch (Exception e) {
          throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No data");
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmpresaView> insertEmpresa(@Valid @RequestBody EmpresaWrite Empresas){
        
        try {
            return ResponseEntity.ok(empresaService.addEmpresas(Empresas));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<EmpresaView> updateHabit(@RequestBody EmpresaWrite Empresas){
        
        try {
            return ResponseEntity.ok(empresaService.updatePerids(Empresas));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
    

    @DeleteMapping("{id}")
    public ResponseEntity<Map<String, Object>> deleteById(@PathVariable long id){
        try {
            empresaService.deletePeridsById(id);
            return ResponseEntity.ok(Map.of(
            "mensaje", "Empresa eliminada",
            "id", id
        ));
        } catch(Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
}
