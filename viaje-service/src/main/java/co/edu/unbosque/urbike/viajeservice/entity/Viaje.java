package co.edu.unbosque.urbike.viajeservice.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity(name = "viajes")
@Table(name = "viajes")
public class Viaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_viaje")
    private Integer idViaje;
    @Column(name = "id_usuario")
    private Integer idUsuario;
    @Column(name = "id_bicicleta")
    private Integer idBicicleta;
    @Column(name = "estacion_inicio")
    private Integer estacionInicio;
    @Column(name = "estacion_fin")
    private Integer estacionFin;
    @Column(name = "fecha_inicio")
    private Timestamp fechaInicio;
    @Column(name = "fecha_fin")
    private Timestamp fechaFin;
    @Column(name = "tarifa_base")
    private Float tarifaBase;
    @Column(name = "minutos_extra")
    private Integer minutosExtra;
    @Column(name = "costo_extra")
    private Float costoExtra;
    private Float total;

    public Viaje(Integer idViaje, Integer idUsuario, Integer idBicicleta, Integer estacionInicio, Integer estacionFin, Timestamp fechaInicio, Timestamp fechaFin, Float tarifaBase, Integer minutosExtra, Float costoExtra, Float total) {
        this.idViaje = idViaje;
        this.idUsuario = idUsuario;
        this.idBicicleta = idBicicleta;
        this.estacionInicio = estacionInicio;
        this.estacionFin = estacionFin;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.tarifaBase = tarifaBase;
        this.minutosExtra = minutosExtra;
        this.costoExtra = costoExtra;
        this.total = total;
    }

    public Viaje() {

    }

    public Integer getIdViaje() {
        return idViaje;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public Integer getIdBicicleta() {
        return idBicicleta;
    }

    public Integer getEstacionInicio() {
        return estacionInicio;
    }

    public Integer getEstacionFin() {
        return estacionFin;
    }

    public Timestamp getFechaInicio() {
        return fechaInicio;
    }

    public Timestamp getFechaFin() {
        return fechaFin;
    }

    public Float getTarifaBase() {
        return tarifaBase;
    }

    public Integer getMinutosExtra() {
        return minutosExtra;
    }

    public Float getCostoExtra() {
        return costoExtra;
    }

    public Float getTotal() {
        return total;
    }
}
