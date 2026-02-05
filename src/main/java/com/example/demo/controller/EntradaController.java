package com.example.demo.controller;

import com.example.demo.model.Entrada;
import com.example.demo.service.EntradaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/entradas")
public class EntradaController {

    private final EntradaService entradaService;

    public EntradaController(EntradaService entradaService) {
        this.entradaService = entradaService;
    }

    @GetMapping
    public List<Entrada> getAll() {
        return entradaService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entrada> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(entradaService.getById(id));
    }

    @PostMapping
    public Entrada create(@RequestBody Entrada entrada) {
        return entradaService.create(entrada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Entrada> update(@PathVariable Integer id, @RequestBody Entrada entrada) {
        return ResponseEntity.ok(entradaService.update(id, entrada));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Entrada> patch(@PathVariable Integer id, @RequestBody Map<String, Object> cambios) {
        return ResponseEntity.ok(entradaService.patch(id, cambios));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        entradaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
