package com.example.demo.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalTime;

@Entity
@Table(name = "horarios_semanales_empleados")
public class HorarioSemanalEmpleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_horario_semanal")
    private Integer idHorarioSemanal;

    @ManyToOne
    @JoinColumn(name = "id_empleado", nullable = false)
    private Empleado empleado;

    @Column(name = "dia_semana", nullable = false)
    private Integer diaSemana;

    @Column(name = "hora_entrada", nullable = false)
    private LocalTime horaEntrada;

    @Column(name = "hora_salida", nullable = false)
    private LocalTime horaSalida;

    @Column(name = "horas_dia", nullable = false, precision = 4, scale = 2)
    private BigDecimal horasDia;

    public HorarioSemanalEmpleado() {}

    public Integer getIdHorarioSemanal() { return idHorarioSemanal; }
    public void setIdHorarioSemanal(Integer idHorarioSemanal) { this.idHorarioSemanal = idHorarioSemanal; }

    public Empleado getEmpleado() { return empleado; }
    public void setEmpleado(Empleado empleado) { this.empleado = empleado; }

    public Integer getDiaSemana() { return diaSemana; }
    public void setDiaSemana(Integer diaSemana) { this.diaSemana = diaSemana; }

    public LocalTime getHoraEntrada() { return horaEntrada; }
    public void setHoraEntrada(LocalTime horaEntrada) { this.horaEntrada = horaEntrada; }

    public LocalTime getHoraSalida() { return horaSalida; }
    public void setHoraSalida(LocalTime horaSalida) { this.horaSalida = horaSalida; }

    public BigDecimal getHorasDia() { return horasDia; }
    public void setHorasDia(BigDecimal horasDia) { this.horasDia = horasDia; }
}
