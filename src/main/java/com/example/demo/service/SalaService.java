package com.example.demo.service;

import com.example.demo.model.Sala;
import com.example.demo.repository.SalaRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class SalaService {
    private final SalaRepository salaRepository;

    public SalaService(SalaRepository salaRepository) {
        this.salaRepository = salaRepository;
    }

    public List<Sala> getAll() {
        return salaRepository.findAll();
    }

    public Sala getById(Integer id) {
        return salaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sala no encontrada con id: " + id));
    }

    public Sala create(Sala sala) {
        return salaRepository.save(sala);
    }

    public Sala update(Integer id, Sala datosNuevos) {
        Sala sala = getById(id);

        sala.setNombreSala(datosNuevos.getNombreSala());
        sala.setCapacidad(datosNuevos.getCapacidad());
        sala.setTipoSala(datosNuevos.getTipoSala());
        sala.setCalidadSonido(datosNuevos.getCalidadSonido());
        sala.setActiva(datosNuevos.getActiva());

        return salaRepository.save(sala);
    }

    public Sala patch(Integer id, Map<String, Object> cambios) {
        Sala sala = getById(id);

        if (cambios.containsKey("nombreSala")) {
            sala.setNombreSala((String) cambios.get("nombreSala"));
        }

        if (cambios.containsKey("capacidad")) {
            sala.setCapacidad((Integer) cambios.get("capacidad"));
        }

        if (cambios.containsKey("tipoSala")) {
            sala.setTipoSala((String) cambios.get("tipoSala"));
        }

        if (cambios.containsKey("calidadSonido")) {
            sala.setCalidadSonido((String) cambios.get("calidadSonido"));
        }

        if (cambios.containsKey("activa")) {
            sala.setActiva((Boolean) cambios.get("activa"));
        }

        return salaRepository.save(sala);
    }

    public void delete(Integer id) {
        salaRepository.deleteById(id);
    }
}
