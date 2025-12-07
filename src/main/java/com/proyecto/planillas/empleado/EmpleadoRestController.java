package com.proyecto.planillas.empleado;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("empleado")
@RequiredArgsConstructor
public class EmpleadoRestController {
    private final EmpleadoService empleadoService;

    @GetMapping
    public ResponseEntity<List<EmpleadoViewDTO>> list() throws ResponseStatusException {
        List<EmpleadoViewDTO> list = empleadoService.getAllEmpleados();
        if (list.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "No data");
        }
        return ResponseEntity.ok(list);
    }

    @GetMapping("{id}")
    public ResponseEntity<EmpleadoViewDTO> getById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(empleadoService.getEmpleadosById(id));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No data");
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmpleadoViewDTO> insertEmpleado(@Valid @RequestBody EmpleadoWriteDTO empleadoWriteDTO) {
        try {
            return ResponseEntity.ok(empleadoService.addEmpleados(empleadoWriteDTO));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmpleadoViewDTO> updateEmpleado(@RequestBody EmpleadoWriteDTO empleadoWriteDTO) {
        try {
            return ResponseEntity.ok(empleadoService.updateEmpleado(empleadoWriteDTO));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteEmpleado(@PathVariable Long id) {
        try {
            empleadoService.deleteEmpleadoById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    // BUSCAR EMPLEADOS POR NOMBRE O DNI
    @GetMapping("/buscar")
    public ResponseEntity<List<EmpleadoViewDTO>> buscar(@RequestParam String texto) {
        List<EmpleadoViewDTO> resultados = empleadoService.buscarEmpleados(texto);
        return ResponseEntity.ok(resultados);
    }

    //delete 
    

}
