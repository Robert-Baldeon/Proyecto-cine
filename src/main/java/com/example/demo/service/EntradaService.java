package com.example.demo.service;

import com.example.demo.model.Entrada;
import com.example.demo.repository.EntradaRepository;
import com.example.demo.repository.ProyeccionRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class EntradaService {

    private final EntradaRepository entradaRepository;
    private final ProyeccionRepository proyeccionRepository;

    public EntradaService(EntradaRepository entradaRepository, ProyeccionRepository proyeccionRepository) {
        this.entradaRepository = entradaRepository;
        this.proyeccionRepository = proyeccionRepository;
    }

    public List<Entrada> getAll() {
        return entradaRepository.findAll();
    }

    public Entrada getById(Integer id) {
        return entradaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entrada no encontrada con id: " + id));
    }

    public Entrada create(Entrada entrada) {
        // Si no viene fecha, la ponemos por defecto como ahora
        if (entrada.getFechaCompra() == null) {
            entrada.setFechaCompra(LocalDateTime.now());
        }
        return entradaRepository.save(entrada);
    }

    public Entrada update(Integer id, Entrada datosNuevos) {
        Entrada entrada = getById(id);
        
        entrada.setProyeccion(datosNuevos.getProyeccion());
        entrada.setFechaCompra(datosNuevos.getFechaCompra());
        
        return entradaRepository.save(entrada);
    }

    public Entrada patch(Integer id, Map<String, Object> cambios) {
        Entrada entrada = getById(id);

        if (cambios.containsKey("fechaCompra")) {
            entrada.setFechaCompra(LocalDateTime.parse((String) cambios.get("fechaCompra")));
        }
        
        if (cambios.containsKey("idProyeccion")) {
            entrada.setProyeccion(proyeccionRepository.findById((Integer) cambios.get("idProyeccion"))
                    .orElseThrow(() -> new RuntimeException("Proyección no encontrada")));
        }

        return entradaRepository.save(entrada);
    }

    public void delete(Integer id) {
        Entrada entrada = getById(id);
        entradaRepository.delete(entrada);
    }
}
