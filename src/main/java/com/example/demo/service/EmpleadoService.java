package com.example.demo.service;

import com.example.demo.model.Empleado;
import com.example.demo.repository.EmpleadoRepository;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service
public class EmpleadoService {

    private final EmpleadoRepository empleadoRepository;

    public EmpleadoService(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    public List<Empleado> getAll() {
        return empleadoRepository.findAll();
    }

    public Empleado getById(Integer id) {
        return empleadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado con id: " + id));
    }

    public Empleado create(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    public Empleado update(Integer id, Empleado datosNuevos) {
        Empleado empleado = getById(id);

        empleado.setNombre(datosNuevos.getNombre());
        empleado.setPuesto(datosNuevos.getPuesto());
        empleado.setTipoJornada(datosNuevos.getTipoJornada());
        empleado.setEmail(datosNuevos.getEmail());
        empleado.setTelefono(datosNuevos.getTelefono());
        empleado.setFechaContratacion(datosNuevos.getFechaContratacion());
        empleado.setSalarioHora(datosNuevos.getSalarioHora());
        empleado.setActivo(datosNuevos.getActivo());

        return empleadoRepository.save(empleado);
    }

    public Empleado patch(Integer id, Map<String, Object> cambios) {
        Empleado empleado = getById(id);

        if (cambios.containsKey("nombre")) empleado.setNombre((String) cambios.get("nombre"));
        if (cambios.containsKey("puesto")) empleado.setPuesto((String) cambios.get("puesto"));
        if (cambios.containsKey("tipoJornada")) empleado.setTipoJornada((String) cambios.get("tipoJornada"));
        if (cambios.containsKey("email")) empleado.setEmail((String) cambios.get("email"));
        if (cambios.containsKey("telefono")) empleado.setTelefono((String) cambios.get("telefono"));
        if (cambios.containsKey("activo")) empleado.setActivo((Boolean) cambios.get("activo"));

        if (cambios.containsKey("salarioHora")) {
            // Convertimos el valor numérico a BigDecimal
            empleado.setSalarioHora(new BigDecimal(cambios.get("salarioHora").toString()));
        }
        if (cambios.containsKey("fechaContratacion")) {
            empleado.setFechaContratacion(LocalDate.parse((String) cambios.get("fechaContratacion")));
        }

        return empleadoRepository.save(empleado);
    }

    public void delete(Integer id) {
        Empleado empleado = getById(id);
        empleadoRepository.delete(empleado);
    }
}
