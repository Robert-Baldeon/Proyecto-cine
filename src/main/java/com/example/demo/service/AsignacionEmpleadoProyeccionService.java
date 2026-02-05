package com.example.demo.service;

import com.example.demo.model.AsignacionEmpleadoProyeccion;
import com.example.demo.repository.AsignacionEmpleadoProyeccionRepository;
import com.example.demo.repository.EmpleadoRepository;
import com.example.demo.repository.ProyeccionRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class AsignacionEmpleadoProyeccionService {

    private final AsignacionEmpleadoProyeccionRepository repository;
    private final EmpleadoRepository empleadoRepository;
    private final ProyeccionRepository proyeccionRepository;

    public AsignacionEmpleadoProyeccionService(AsignacionEmpleadoProyeccionRepository repository, 
                                               EmpleadoRepository empleadoRepository, 
                                               ProyeccionRepository proyeccionRepository) {
        this.repository = repository;
        this.empleadoRepository = empleadoRepository;
        this.proyeccionRepository = proyeccionRepository;
    }

    public List<AsignacionEmpleadoProyeccion> getAll() {
        return repository.findAll();
    }

    public AsignacionEmpleadoProyeccion getById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Asignación no encontrada con id: " + id));
    }

    public AsignacionEmpleadoProyeccion create(AsignacionEmpleadoProyeccion asignacion) {
        return repository.save(asignacion);
    }

    public AsignacionEmpleadoProyeccion update(Integer id, AsignacionEmpleadoProyeccion datosNuevos) {
        AsignacionEmpleadoProyeccion asignacion = getById(id);

        asignacion.setEmpleado(datosNuevos.getEmpleado());
        asignacion.setProyeccion(datosNuevos.getProyeccion());
        asignacion.setRol(datosNuevos.getRol());

        return repository.save(asignacion);
    }

    public AsignacionEmpleadoProyeccion patch(Integer id, Map<String, Object> cambios) {
        AsignacionEmpleadoProyeccion asignacion = getById(id);

        if (cambios.containsKey("rol")) {
            asignacion.setRol((String) cambios.get("rol"));
        }
        
        if (cambios.containsKey("idEmpleado")) {
            asignacion.setEmpleado(empleadoRepository.findById((Integer) cambios.get("idEmpleado"))
                    .orElseThrow(() -> new RuntimeException("Empleado no encontrado")));
        }
        
        if (cambios.containsKey("idProyeccion")) {
            asignacion.setProyeccion(proyeccionRepository.findById((Integer) cambios.get("idProyeccion"))
                    .orElseThrow(() -> new RuntimeException("Proyección no encontrada")));
        }

        return repository.save(asignacion);
    }

    public void delete(Integer id) {
        AsignacionEmpleadoProyeccion asignacion = getById(id);
        repository.delete(asignacion);
    }
}
