package com.proyecto.planillas.area;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class AreaService {
    private final AreaRepository areaRepository;
    private final AreaMapper areaMapper;

    public List<AreaViewDTO> getAllAreas() {
        return areaRepository.findAll().stream().map(areaMapper::toDto).toList();

    }

    public AreaViewDTO getAreaById(Long id) {
        return areaMapper.toDto(areaRepository.findById(id).orElseThrow());
    }

    @Transactional
    public AreaViewDTO addArea(AreaWriteDTO area) {
        return save(area);
    }

    @Transactional
    public AreaViewDTO updateArea(AreaWriteDTO area) {
        if (!areaRepository.existsById(area.id())) {
            throw new IllegalStateException("Id no encotrado");
        }
        return save(area);
    }

    private AreaViewDTO save(AreaWriteDTO area) {
        return areaMapper.toDto(areaRepository.save(areaMapper.toEntity(area)));
    }

    @Transactional
    public void deleteAreaById(Long id) {
        try {
            areaRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("ID not found" + (id));
        }
    }

}