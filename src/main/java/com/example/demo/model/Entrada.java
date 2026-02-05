package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "entradas")
public class Entrada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_entrada")
    private Integer idEntrada;

    @ManyToOne
    @JoinColumn(name = "id_proyeccion", nullable = false)
    private Proyeccion proyeccion;

    @Column(name = "fecha_compra", nullable = false, updatable = false)
    private LocalDateTime fechaCompra;

    public Entrada() {}

    public Integer getIdEntrada() { return idEntrada; }
    public void setIdEntrada(Integer idEntrada) { this.idEntrada = idEntrada; }

    public Proyeccion getProyeccion() { return proyeccion; }
    public void setProyeccion(Proyeccion proyeccion) { this.proyeccion = proyeccion; }

    public LocalDateTime getFechaCompra() { return fechaCompra; }
    public void setFechaCompra(LocalDateTime fechaCompra) { this.fechaCompra = fechaCompra; }
}
