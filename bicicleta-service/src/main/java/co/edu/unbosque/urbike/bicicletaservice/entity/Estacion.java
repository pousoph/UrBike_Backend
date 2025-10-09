package co.edu.unbosque.urbike.bicicletaservice.entity;

import jakarta.persistence.*;

@Table(name = "estaciones")
@Entity(name = "estaciones")
public class Estacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEstacion")
    private Integer idEstacion;
    private String nombre;
    private String categoria;
    private Integer capacidad;
    private Float latitud;
    private Float longitud;

    public Estacion(Integer idEstacion, String nombre, String categoria, Integer capacidad, Float latitud, Float longitud) {
        this.idEstacion = idEstacion;
        this.nombre = nombre;
        this.categoria = categoria;
        this.capacidad = capacidad;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public Estacion() {

    }

    public Integer getIdEstacion() {
        return idEstacion;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public Float getLatitud() {
        return latitud;
    }

    public Float getLongitud() {
        return longitud;
    }

    public String getCategoria() {
        return categoria;
    }
}
