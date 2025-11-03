package com.proyecto.planillas.area;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("area")
@RequiredArgsConstructor
public class AreaRestController {
    private final AreaService areaService;
    @GetMapping
    public ResponseEntity<List<AreaViewDTO>> list() throws ResponseStatusException{
        List<AreaViewDTO> list = areaService.getAllAreas();
        if (list.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT,"No data");
        }
        return ResponseEntity.ok(list);
    }

    @GetMapping("{id}")
    public ResponseEntity<AreaViewDTO> getById(Long id){
        try {
            return ResponseEntity.ok(areaService.getAreaById(id));
        } catch (Exception e) {
          throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No data");
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AreaViewDTO> insertArea(AreaWriteDTO areaWriteDTO){
        try {
            return ResponseEntity.ok(areaService.addArea(areaWriteDTO));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<AreaViewDTO> updateArea(AreaWriteDTO areaWriteDTO){
        try {
            return ResponseEntity.ok(areaService.updateArea(areaWriteDTO));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }       

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteArea(Long id){
        try {
            areaService.deleteAreaById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }   

}
