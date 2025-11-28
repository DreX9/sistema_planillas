package com.proyecto.planillas.asistencia;

import java.util.List;

import org.springframework.data.convert.ReadingConverter;
import org.springframework.stereotype.Service;

import com.proyecto.planillas.horario.HorarioRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
// @Service
// @RequiredArgsConstructor
public class AsistenciaService {
/*
private final AsistenciaRepository asistenciaRepository;
private final AsistenciaMapper asistenciaMapper;

    public List<AsistenciaViewDTO> getAllAsistencias() {
        return asistenciaRepository.findAll().stream().map(AsistenciaMapper::toDto).toList();
    }

    public AsistenciaViewDTO getAsistenciaById(Long id) {
        return AsistenciaMapper.toDto(asistenciaRepository.findById(id).orElseThrow());
    }
    @Transactional
    public AsistenciaViewDTO addAsistencia(AsistenciaWriteDTO asistencia) {
        return save(asistencia);
    }
    @Transactional
    public AsistenciaViewDTO updateAsistencia(AsistenciaWriteDTO asistencia)  {
        if (!asistenciaRepository.existsById(asistencia.id())) {
            throw new IllegalStateException("Id no encotrado"); 
        }

        return save(asistencia);
    }

    public AsistenciaViewDTO save(AsistenciaWriteDTO asistencia) {
        return AsistenciaMapper.toDto(asistenciaRepository.save(AsistenciaMapper.toEntity(asistencia)));
    }

    @Transactional
    public void deleteAsistenciaById(Long id)  {
        try {
            asistenciaRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("ID not found"+ (id));
        }

    }
    */
}
