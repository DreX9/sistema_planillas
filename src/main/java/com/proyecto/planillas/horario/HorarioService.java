package com.proyecto.planillas.horario;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HorarioService {
private final HorarioRepository horarioRepository;
private final HorarioMapper horarioMapper;

    public List<HorarioViewDTO> getAllHorarios() {
        return horarioRepository.findAll().stream().map(horarioMapper::toDto).toList();
    }

    public HorarioViewDTO getHorarioById(Long id) {
        return horarioMapper.toDto(horarioRepository.findById(id).orElseThrow());
    }
    @Transactional
    public HorarioViewDTO addHorario(HorarioWriteDTO horario) {
        return save(horario);
    }

    @Transactional
    public HorarioViewDTO updateHorario(HorarioWriteDTO horario)  {
        if (!horarioRepository.existsById(horario.id())) {
            throw new IllegalStateException("Id no encotrado"); 
        }

        return save(horario);
    }

    public HorarioViewDTO save(HorarioWriteDTO horario) {
        return horarioMapper.toDto(horarioRepository.save(horarioMapper.toEntity(horario)));
    }

    @Transactional
    public void deleteHorarioById(Long id)  {
        try {
            horarioRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("ID not found"+ (id));
        }

    }

}
