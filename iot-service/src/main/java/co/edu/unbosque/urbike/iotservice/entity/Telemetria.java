package co.edu.unbosque.urbike.iotservice.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Table(name = "telemetria")
@Entity(name = "telemetria")
public class Telemetria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_telemetria")
    private Integer idTelemetria;
    @Column(name = "id_bicicleta")
    private Integer idBicicleta;
    private Timestamp fecha;
    private Float latitud;
    private Float longitud;
    private Integer bateria;
    @Column(name = "estado_candado")
    private String estadoCandado;

    public Telemetria(Integer idTelemetria, Integer idBicicleta, Timestamp fecha, Float latitud, Float longitud, Integer bateria, String estadoCandado) {
        this.idTelemetria = idTelemetria;
        this.idBicicleta = idBicicleta;
        this.fecha = fecha;
        this.latitud = latitud;
        this.longitud = longitud;
        this.bateria = bateria;
        this.estadoCandado = estadoCandado;
    }

    public Telemetria() {

    }

    public Integer getIdTelemetria() {
        return idTelemetria;
    }

    public Integer getIdBicicleta() {
        return idBicicleta;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public Float getLatitud() {
        return latitud;
    }

    public Float getLongitud() {
        return longitud;
    }

    public Integer getBateria() {
        return bateria;
    }

    public String getEstadoCandado() {
        return estadoCandado;
    }
}
