package com.proyecto.planillas.asistencia;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AsistenciaService {

    private final AsistenciaRepository asistenciaRepository;
    private final AsistenciaMapper asistenciaMapper;

    public List<AsistenciaViewDTO> getAllAsistencias() {
        return asistenciaRepository.findAll().stream().map(asistenciaMapper::toDto).toList();
    }

    public AsistenciaViewDTO getAsistenciaById(Long id) {
        return asistenciaMapper.toDto(asistenciaRepository.findById(id).orElseThrow());
    }

    

    @Transactional
    public AsistenciaViewDTO addAsistencia(AsistenciaWriteDTO asistencia) {
        return save(asistencia);
    }

    @Transactional
    public AsistenciaViewDTO updateAsistencia(AsistenciaWriteDTO asistencia) {
        if (!asistenciaRepository.existsById(asistencia.id())) {
            throw new IllegalStateException("Id no encotrado");
        }

        return save(asistencia);
    }

    public AsistenciaViewDTO save(AsistenciaWriteDTO asistencia) {
        return asistenciaMapper.toDto(asistenciaRepository.save(asistenciaMapper.toEntity(asistencia)));
    }

    @Transactional
    public void deleteAsistenciaById(Long id) {
        try {
            asistenciaRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("ID not found" + (id));
        }

    }

}
