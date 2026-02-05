package com.example.demo.service;

import com.example.demo.model.Proyeccion;
import com.example.demo.repository.ProyeccionRepository;
import com.example.demo.repository.PeliculaRepository;
import com.example.demo.repository.SalaRepository;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class ProyeccionService {

    private final ProyeccionRepository proyeccionRepository;
    private final PeliculaRepository peliculaRepository;
    private final SalaRepository salaRepository;

    public ProyeccionService(ProyeccionRepository proyeccionRepository, 
                             PeliculaRepository peliculaRepository, 
                             SalaRepository salaRepository) {
        this.proyeccionRepository = proyeccionRepository;
        this.peliculaRepository = peliculaRepository;
        this.salaRepository = salaRepository;
    }

    public List<Proyeccion> getAll() {
        return proyeccionRepository.findAll();
    }

    public Proyeccion getById(Integer id) {
        return proyeccionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Proyección no encontrada con id: " + id));
    }

    public Proyeccion create(Proyeccion proyeccion) {
        return proyeccionRepository.save(proyeccion);
    }

    public Proyeccion update(Integer id, Proyeccion datosNuevos) {
        Proyeccion proyeccion = getById(id);

        proyeccion.setPelicula(datosNuevos.getPelicula());
        proyeccion.setSala(datosNuevos.getSala());
        proyeccion.setFechaHoraInicio(datosNuevos.getFechaHoraInicio());
        proyeccion.setFechaHoraFin(datosNuevos.getFechaHoraFin());
        proyeccion.setPrecioEntrada(datosNuevos.getPrecioEntrada());
        proyeccion.setAsientosDisponibles(datosNuevos.getAsientosDisponibles());

        return proyeccionRepository.save(proyeccion);
    }

    public Proyeccion patch(Integer id, Map<String, Object> cambios) {
        Proyeccion proyeccion = getById(id);

        if (cambios.containsKey("fechaHoraInicio")) {
            proyeccion.setFechaHoraInicio(LocalDateTime.parse((String) cambios.get("fechaHoraInicio")));
        }
        if (cambios.containsKey("fechaHoraFin")) {
            proyeccion.setFechaHoraFin(LocalDateTime.parse((String) cambios.get("fechaHoraFin")));
        }
        if (cambios.containsKey("precioEntrada")) {
            proyeccion.setPrecioEntrada(new BigDecimal(cambios.get("precioEntrada").toString()));
        }
        if (cambios.containsKey("asientosDisponibles")) {
            proyeccion.setAsientosDisponibles((Integer) cambios.get("asientosDisponibles"));
        }
        
        // Para relaciones en PATCH, normalmente se envía el ID
        if (cambios.containsKey("idPelicula")) {
            proyeccion.setPelicula(peliculaRepository.findById((Integer) cambios.get("idPelicula")).orElseThrow());
        }
        if (cambios.containsKey("idSala")) {
            proyeccion.setSala(salaRepository.findById((Integer) cambios.get("idSala")).orElseThrow());
        }

        return proyeccionRepository.save(proyeccion);
    }

    public void delete(Integer id) {
        Proyeccion proyeccion = getById(id);
        proyeccionRepository.delete(proyeccion);
    }
}
