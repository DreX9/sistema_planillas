package com.proyecto.planillas.empresa;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmpresaService {
    private final EmpresaRepository empresaRepository;
    private final EmpresaMapper empresaMapper;

    public List<EmpresaView> getAllEmpresas() {
     
        return empresaRepository.findAll().stream().map(empresaMapper::toDto).toList();
    }

    public EmpresaView getEmpresasById(Long id) {
        return empresaMapper.toDto(empresaRepository.findById(id).orElseThrow());
    }
    @Transactional
    public EmpresaView addEmpresas(EmpresaWrite Empresas) {
        return save(Empresas);
    }
   
    @Transactional
    public EmpresaView updatePerids(EmpresaWrite Empresas)  {
        if (!empresaRepository.existsById(Empresas.id())) {
            throw new IllegalStateException("Id no encotrado"); 
        }
       
        return save(Empresas);
    }
    

    private EmpresaView save(EmpresaWrite Empresas) {
         return empresaMapper.toDto(empresaRepository.save(empresaMapper.toEntity(Empresas)));
    }

    @Transactional
    public void deletePeridsById(Long id)  {
        try {
            empresaRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("ID not found"+ (id));
        }
        
    }
}
