package com.example.demo.controller;

import com.example.demo.model.HorarioSemanalEmpleado;
import com.example.demo.service.HorarioSemanalEmpleadoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/horarios-semanales")
public class HorarioSemanalEmpleadoController {

    private final HorarioSemanalEmpleadoService service;

    public HorarioSemanalEmpleadoController(HorarioSemanalEmpleadoService service) {
        this.service = service;
    }

    @GetMapping
    public List<HorarioSemanalEmpleado> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HorarioSemanalEmpleado> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public HorarioSemanalEmpleado create(@RequestBody HorarioSemanalEmpleado horario) {
        return service.create(horario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HorarioSemanalEmpleado> update(@PathVariable Integer id, @RequestBody HorarioSemanalEmpleado horario) {
        return ResponseEntity.ok(service.update(id, horario));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<HorarioSemanalEmpleado> patch(@PathVariable Integer id, @RequestBody Map<String, Object> cambios) {
        return ResponseEntity.ok(service.patch(id, cambios));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
