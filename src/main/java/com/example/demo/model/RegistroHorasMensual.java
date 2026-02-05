package com.example.demo.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "registro_horas_mensual")
public class RegistroHorasMensual {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRegistro;

    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private Empleado empleado;
    private Integer mes;
    private Integer anio;
    private BigDecimal horasTotales;
    private BigDecimal horasExtra;

    public Integer getIdRegistro() { return idRegistro; }
    public void setIdRegistro(Integer idRegistro) { this.idRegistro = idRegistro; }

    public Empleado getEmpleado() { return empleado; }
    public void setEmpleado(Empleado empleado) { this.empleado = empleado; }

    public Integer getMes() { return mes; }
    public void setMes(Integer mes) { this.mes = mes; }

    public Integer getAnio() { return anio; }
    public void setAnio(Integer anio) { this.anio = anio; }

    public BigDecimal getHorasTotales() { return horasTotales; }
    public void setHorasTotales(BigDecimal horasTotales) { this.horasTotales = horasTotales; }

    public BigDecimal getHorasExtra() { return horasExtra; }
    public void setHorasExtra(BigDecimal horasExtra) { this.horasExtra = horasExtra; }
}
