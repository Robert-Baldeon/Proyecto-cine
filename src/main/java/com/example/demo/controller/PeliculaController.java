package com.example.demo.controller;

import com.example.demo.model.Pelicula;
import com.example.demo.service.PeliculaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/peliculas")
public class PeliculaController {

    private final PeliculaService peliculaService;

    public PeliculaController(PeliculaService peliculaService) {
        this.peliculaService = peliculaService;
    }

    @GetMapping
    public List<Pelicula> getAll() {
        return peliculaService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pelicula> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(peliculaService.getById(id));
    }

    @PostMapping
    public Pelicula create(@RequestBody Pelicula pelicula) {
        return peliculaService.create(pelicula);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pelicula> update(@PathVariable Integer id, @RequestBody Pelicula pelicula) {
        return ResponseEntity.ok(peliculaService.update(id, pelicula));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Pelicula> patch(@PathVariable Integer id, @RequestBody Map<String, Object> cambios) {
        return ResponseEntity.ok(peliculaService.patch(id, cambios));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        peliculaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
