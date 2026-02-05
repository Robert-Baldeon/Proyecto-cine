package com.example.demo.controller;

import com.example.demo.model.AsignacionEmpleadoProyeccion;
import com.example.demo.service.AsignacionEmpleadoProyeccionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/asignaciones")
public class AsignacionEmpleadoProyeccionController {

    private final AsignacionEmpleadoProyeccionService service;

    public AsignacionEmpleadoProyeccionController(AsignacionEmpleadoProyeccionService service) {
        this.service = service;
    }

    @GetMapping
    public List<AsignacionEmpleadoProyeccion> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AsignacionEmpleadoProyeccion> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public AsignacionEmpleadoProyeccion create(@RequestBody AsignacionEmpleadoProyeccion asignacion) {
        return service.create(asignacion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AsignacionEmpleadoProyeccion> update(@PathVariable Integer id, @RequestBody AsignacionEmpleadoProyeccion asignacion) {
        return ResponseEntity.ok(service.update(id, asignacion));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<AsignacionEmpleadoProyeccion> patch(@PathVariable Integer id, @RequestBody Map<String, Object> cambios) {
        return ResponseEntity.ok(service.patch(id, cambios));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
