package com.example.demo.controller;

import com.example.demo.model.Sala;
import com.example.demo.service.SalaService;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/salas")
public class SalaController {
    private final SalaService salaService;

    public SalaController(SalaService salaService) {
        this.salaService = salaService;
    }

    @GetMapping
    public List<Sala> getAll() {
        return salaService.getAll();
    }

    @GetMapping("/{id}")
    public Sala getById(@PathVariable Integer id) {
        return salaService.getById(id);
    }

    @PostMapping
    public Sala create(@RequestBody Sala sala) {
        return salaService.create(sala);
    }

    @PutMapping("/{id}")
    public Sala update(@PathVariable Integer id, @RequestBody Sala sala) {
        return salaService.update(id, sala);
    }

    @PatchMapping("/{id}")
    public Sala patch(@PathVariable Integer id, @RequestBody Map<String, Object> cambios) {
        return salaService.patch(id, cambios);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        salaService.delete(id);
    }
}
