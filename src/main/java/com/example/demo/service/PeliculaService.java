package com.example.demo.service;

import com.example.demo.model.Pelicula;
import com.example.demo.repository.PeliculaRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service
public class PeliculaService {

    private final PeliculaRepository peliculaRepository;

    public PeliculaService(PeliculaRepository peliculaRepository) {
        this.peliculaRepository = peliculaRepository;
    }

    public List<Pelicula> getAll() {
        return peliculaRepository.findAll();
    }

    public Pelicula getById(Integer id) {
        return peliculaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Película no encontrada con id: " + id));
    }

    public Pelicula create(Pelicula pelicula) {
        return peliculaRepository.save(pelicula);
    }

    public Pelicula update(Integer id, Pelicula datosNuevos) {
        Pelicula pelicula = getById(id);

        pelicula.setTitulo(datosNuevos.getTitulo());
        pelicula.setDuracionMinutos(datosNuevos.getDuracionMinutos());
        pelicula.setGenero(datosNuevos.getGenero());
        pelicula.setClasificacion(datosNuevos.getClasificacion());
        pelicula.setDirector(datosNuevos.getDirector());
        pelicula.setSinopsis(datosNuevos.getSinopsis());
        pelicula.setFechaEstreno(datosNuevos.getFechaEstreno());
        pelicula.setPopularidad(datosNuevos.getPopularidad());
        pelicula.setActiva(datosNuevos.getActiva());
        pelicula.setFechaBaja(datosNuevos.getFechaBaja());

        return peliculaRepository.save(pelicula);
    }

    public Pelicula patch(Integer id, Map<String, Object> cambios) {
        Pelicula pelicula = getById(id);

        if (cambios.containsKey("titulo")) pelicula.setTitulo((String) cambios.get("titulo"));
        if (cambios.containsKey("duracionMinutos")) pelicula.setDuracionMinutos((Integer) cambios.get("duracionMinutos"));
        if (cambios.containsKey("genero")) pelicula.setGenero((String) cambios.get("genero"));
        if (cambios.containsKey("clasificacion")) pelicula.setClasificacion((String) cambios.get("clasificacion"));
        if (cambios.containsKey("director")) pelicula.setDirector((String) cambios.get("director"));
        if (cambios.containsKey("sinopsis")) pelicula.setSinopsis((String) cambios.get("sinopsis"));
        if (cambios.containsKey("popularidad")) pelicula.setPopularidad((Integer) cambios.get("popularidad"));
        if (cambios.containsKey("activa")) pelicula.setActiva((Boolean) cambios.get("activa"));
        
        if (cambios.containsKey("fechaEstreno")) {
            pelicula.setFechaEstreno(LocalDate.parse((String) cambios.get("fechaEstreno")));
        }
        if (cambios.containsKey("fechaBaja")) {
            pelicula.setFechaBaja(LocalDate.parse((String) cambios.get("fechaBaja")));
        }

        return peliculaRepository.save(pelicula);
    }

    public void delete(Integer id) {
        Pelicula pelicula = getById(id);
        peliculaRepository.delete(pelicula);
    }
}

