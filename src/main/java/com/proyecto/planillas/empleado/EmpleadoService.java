package com.proyecto.planillas.empleado;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmpleadoService {
    private final EmpleadoRepository empleadoRepository;
    private final EmpleadoMapper empleadoMapper;

    public List<EmpleadoViewDTO> getAllEmpleados() {

        return empleadoRepository.findAll().stream().map(empleadoMapper::toDto).toList();
    }

    public EmpleadoViewDTO getEmpleadosById(Long id) {
        return empleadoMapper.toDto(empleadoRepository.findById(id).orElseThrow());
    }

    @Transactional
    public EmpleadoViewDTO addEmpleados(EmpleadoWriteDTO Empleados) {
        return save(Empleados);
    }

    @Transactional
    public EmpleadoViewDTO updateEmpleado(EmpleadoWriteDTO Empleados) {
        if (!empleadoRepository.existsById(Empleados.id())) {
            throw new IllegalStateException("Id no encotrado");
        }

        return save(Empleados);
    }

    private EmpleadoViewDTO save(EmpleadoWriteDTO Empleados) {
        return empleadoMapper.toDto(empleadoRepository.save(empleadoMapper.toEntity(Empleados)));
    }

    @Transactional
    public void deleteEmpleadoById(Long id) {
        try {
            empleadoRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("ID not found" + (id));
        }

    }
}
