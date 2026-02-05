package com.example.demo.controller;

import com.example.demo.model.Proyeccion;
import com.example.demo.service.ProyeccionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/proyecciones")
public class ProyeccionController {

    private final ProyeccionService proyeccionService;

    public ProyeccionController(ProyeccionService proyeccionService) {
        this.proyeccionService = proyeccionService;
    }

    @GetMapping
    public List<Proyeccion> getAll() {
        return proyeccionService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Proyeccion> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(proyeccionService.getById(id));
    }

    @PostMapping
    public Proyeccion create(@RequestBody Proyeccion proyeccion) {
        return proyeccionService.create(proyeccion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Proyeccion> update(@PathVariable Integer id, @RequestBody Proyeccion proyeccion) {
        return ResponseEntity.ok(proyeccionService.update(id, proyeccion));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Proyeccion> patch(@PathVariable Integer id, @RequestBody Map<String, Object> cambios) {
        return ResponseEntity.ok(proyeccionService.patch(id, cambios));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        proyeccionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
