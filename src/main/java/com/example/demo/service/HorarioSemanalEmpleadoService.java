package com.example.demo.service;

import com.example.demo.model.HorarioSemanalEmpleado;
import com.example.demo.repository.HorarioSemanalEmpleadoRepository;
import com.example.demo.repository.EmpleadoRepository;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

@Service
public class HorarioSemanalEmpleadoService {

    private final HorarioSemanalEmpleadoRepository repository;
    private final EmpleadoRepository empleadoRepository;

    public HorarioSemanalEmpleadoService(HorarioSemanalEmpleadoRepository repository, EmpleadoRepository empleadoRepository) {
        this.repository = repository;
        this.empleadoRepository = empleadoRepository;
    }

    public List<HorarioSemanalEmpleado> getAll() {
        return repository.findAll();
    }

    public HorarioSemanalEmpleado getById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Horario no encontrado con id: " + id));
    }

    public HorarioSemanalEmpleado create(HorarioSemanalEmpleado horario) {
        return repository.save(horario);
    }

    public HorarioSemanalEmpleado update(Integer id, HorarioSemanalEmpleado datosNuevos) {
        HorarioSemanalEmpleado horario = getById(id);

        horario.setEmpleado(datosNuevos.getEmpleado());
        horario.setDiaSemana(datosNuevos.getDiaSemana());
        horario.setHoraEntrada(datosNuevos.getHoraEntrada());
        horario.setHoraSalida(datosNuevos.getHoraSalida());
        horario.setHorasDia(datosNuevos.getHorasDia());

        return repository.save(horario);
    }

    public HorarioSemanalEmpleado patch(Integer id, Map<String, Object> cambios) {
        HorarioSemanalEmpleado horario = getById(id);

        if (cambios.containsKey("diaSemana")) horario.setDiaSemana((Integer) cambios.get("diaSemana"));
        if (cambios.containsKey("horaEntrada")) {
            horario.setHoraEntrada(LocalTime.parse((String) cambios.get("horaEntrada")));
        }
        if (cambios.containsKey("horaSalida")) {
            horario.setHoraSalida(LocalTime.parse((String) cambios.get("horaSalida")));
        }
        if (cambios.containsKey("horasDia")) {
            horario.setHorasDia(new BigDecimal(cambios.get("horasDia").toString()));
        }
        if (cambios.containsKey("idEmpleado")) {
            horario.setEmpleado(empleadoRepository.findById((Integer) cambios.get("idEmpleado"))
                    .orElseThrow(() -> new RuntimeException("Empleado no encontrado")));
        }

        return repository.save(horario);
    }

    public void delete(Integer id) {
        HorarioSemanalEmpleado horario = getById(id);
        repository.delete(horario);
    }
}
