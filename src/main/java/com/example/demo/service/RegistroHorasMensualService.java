package com.example.demo.service;

import com.example.demo.model.RegistroHorasMensual;
import com.example.demo.repository.RegistroHorasMensualRepository;
import com.example.demo.repository.EmpleadoRepository;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Service
public class RegistroHorasMensualService {
    private final RegistroHorasMensualRepository registroHorasMensualRepository;
    private final EmpleadoRepository empleadoRepository;

    public RegistroHorasMensualService(RegistroHorasMensualRepository registroHorasMensualRepository, EmpleadoRepository empleadoRepository) {
        this.registroHorasMensualRepository = registroHorasMensualRepository;
        this.empleadoRepository = empleadoRepository;
    }

    public List<RegistroHorasMensual> getAll() {
        return registroHorasMensualRepository.findAll();
    }

    public RegistroHorasMensual getById(Integer id) {
        return registroHorasMensualRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registro de horas no encontrado"));
    }

    public RegistroHorasMensual create(RegistroHorasMensual registro) {
        return registroHorasMensualRepository.save(registro);
    }

    public RegistroHorasMensual update(Integer id, RegistroHorasMensual datosNuevos) {
        RegistroHorasMensual registro = getById(id);

        registro.setEmpleado(datosNuevos.getEmpleado());
        registro.setMes(datosNuevos.getMes());
        registro.setAnio(datosNuevos.getAnio());
        registro.setHorasTotales(datosNuevos.getHorasTotales());
        registro.setHorasExtra(datosNuevos.getHorasExtra());

        return registroHorasMensualRepository.save(registro);
    }

    public RegistroHorasMensual patch(Integer id, Map<String, Object> cambios) {
        RegistroHorasMensual registro = getById(id);

        if (cambios.containsKey("idEmpleado")) {
            registro.setEmpleado(empleadoRepository.findById((Integer) cambios.get("idEmpleado"))
                    .orElseThrow(() -> new RuntimeException("Empleado no encontrado")));
        }

        if (cambios.containsKey("mes")) {
            registro.setMes((Integer) cambios.get("mes"));
        } 

        if (cambios.containsKey("anio")) {
            registro.setAnio((Integer) cambios.get("anio"));
        }
        
        if (cambios.containsKey("horasTotales")) {
            registro.setHorasTotales(new BigDecimal(cambios.get("horasTotales").toString()));
        }

        if (cambios.containsKey("horasExtra")) {
            registro.setHorasExtra(new BigDecimal(cambios.get("horasExtra").toString()));
        }

        return registroHorasMensualRepository.save(registro);
    }

    public void delete(Integer id) {
        registroHorasMensualRepository.deleteById(id);
    }
}
