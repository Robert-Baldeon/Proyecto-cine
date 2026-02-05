package com.example.demo.controller;

import com.example.demo.model.RegistroHorasMensual;
import com.example.demo.service.RegistroHorasMensualService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/registro-horas")
public class RegistroHorasMensualController {
    private final RegistroHorasMensualService registroHorasMensualService;

    public RegistroHorasMensualController(RegistroHorasMensualService registroHorasMensualService) {
        this.registroHorasMensualService = registroHorasMensualService;
    }

    @GetMapping
    public List<RegistroHorasMensual> getAll() {
        return registroHorasMensualService.getAll();
    }

    @GetMapping("/{id}")
    public RegistroHorasMensual getById(@PathVariable Integer id) {
        return registroHorasMensualService.getById(id);
    }

    @PostMapping
    public RegistroHorasMensual create(@RequestBody RegistroHorasMensual registro) {
        return registroHorasMensualService.create(registro);
    }

    @PutMapping("/{id}")
    public RegistroHorasMensual update(@PathVariable Integer id, @RequestBody RegistroHorasMensual registro) {
        return registroHorasMensualService.update(id, registro);
    }

    @PatchMapping("/{id}")
    public RegistroHorasMensual patch(@PathVariable Integer id, @RequestBody Map<String, Object> cambios) {
        return registroHorasMensualService.patch(id, cambios);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        registroHorasMensualService.delete(id);
    }
}
