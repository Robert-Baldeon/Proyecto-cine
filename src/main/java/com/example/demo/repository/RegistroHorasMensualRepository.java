package com.example.demo.repository;

import com.example.demo.model.RegistroHorasMensual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroHorasMensualRepository extends JpaRepository<RegistroHorasMensual, Integer> {}
