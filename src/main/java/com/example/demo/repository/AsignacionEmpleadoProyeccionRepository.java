package com.example.demo.repository;

import com.example.demo.model.AsignacionEmpleadoProyeccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsignacionEmpleadoProyeccionRepository extends JpaRepository<AsignacionEmpleadoProyeccion, Integer> {}
