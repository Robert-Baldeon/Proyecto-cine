package com.example.demo.controller;

import com.example.demo.model.Empleado;
import com.example.demo.service.EmpleadoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {

    private final EmpleadoService empleadoService;

    public EmpleadoController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @GetMapping
    public List<Empleado> getAll() {
        return empleadoService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empleado> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(empleadoService.getById(id));
    }

    @PostMapping
    public Empleado create(@RequestBody Empleado empleado) {
        return empleadoService.create(empleado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empleado> update(@PathVariable Integer id, @RequestBody Empleado empleado) {
        return ResponseEntity.ok(empleadoService.update(id, empleado));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Empleado> patch(@PathVariable Integer id, @RequestBody Map<String, Object> cambios) {
        return ResponseEntity.ok(empleadoService.patch(id, cambios));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        empleadoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
