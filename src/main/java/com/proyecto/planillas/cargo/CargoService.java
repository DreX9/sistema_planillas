package com.proyecto.planillas.cargo;

import java.util.List;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CargoService {
    private final CargoRepository cargoRepository;
    private final CargoMapper cargoMapper;

    public List<CargoView> getAllCargos(){
        return cargoRepository.findAll().stream().map(cargoMapper::toDto).toList();
    }

    public CargoView getCargosbyId(Long id){
        return cargoMapper.toDto(cargoRepository.findById(id).orElseThrow());
    }

    //añadir
    @Transactional
    public CargoView addCargos(CargoWrite Cargos){
        return save(Cargos);
    }

    @Transactional
    public CargoView updateCargo(CargoWrite Cargos){
        if (!cargoRepository.existsById(Cargos.id())){
            throw new IllegalStateException("Id no encontrado");
        }
        return save(Cargos);
    }

    //para que funcione el save
    private CargoView save (CargoWrite Cargos){
        return cargoMapper.toDto(cargoRepository.save(cargoMapper.toEntity(Cargos)));
    }
    
    //para que funcione el update 
    public void deleteCargoById(Long id){
        try {
            cargoRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("ID not found"+ (id));
        }
    }



}
