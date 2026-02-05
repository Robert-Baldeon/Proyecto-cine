package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "peliculas")
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pelicula")
    private Integer idPelicula;

    @Column(nullable = false, unique = true, length = 200)
    private String titulo;

    @Column(name = "duracion_minutos", nullable = false)
    private Integer duracionMinutos;

    @Column(length = 50)
    private String genero;

    @Column(length = 10)
    private String clasificacion;

    @Column(nullable = false, length = 100)
    private String director;

    @Column(columnDefinition = "TEXT")
    private String sinopsis;

    @Column(name = "fecha_estreno", nullable = false)
    private LocalDate fechaEstreno;

    @Column(nullable = false)
    private Integer popularidad;

    @Column(nullable = false)
    private Boolean activa;

    @Column(name = "fecha_baja")
    private LocalDate fechaBaja;

    public Pelicula() {}

    public Integer getIdPelicula() { return idPelicula; }
    public void setIdPelicula(Integer idPelicula) { this.idPelicula = idPelicula; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public Integer getDuracionMinutos() { return duracionMinutos; }
    public void setDuracionMinutos(Integer duracionMinutos) { this.duracionMinutos = duracionMinutos; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    public String getClasificacion() { return clasificacion; }
    public void setClasificacion(String clasificacion) { this.clasificacion = clasificacion; }

    public String getDirector() { return director; }
    public void setDirector(String director) { this.director = director; }

    public String getSinopsis() { return sinopsis; }
    public void setSinopsis(String sinopsis) { this.sinopsis = sinopsis; }

    public LocalDate getFechaEstreno() { return fechaEstreno; }
    public void setFechaEstreno(LocalDate fechaEstreno) { this.fechaEstreno = fechaEstreno; }

    public Integer getPopularidad() { return popularidad; }
    public void setPopularidad(Integer popularidad) { this.popularidad = popularidad; }

    public Boolean getActiva() { return activa; }
    public void setActiva(Boolean activa) { this.activa = activa; }

    public LocalDate getFechaBaja() { return fechaBaja; }
    public void setFechaBaja(LocalDate fechaBaja) { this.fechaBaja = fechaBaja; }
}
