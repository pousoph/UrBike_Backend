package co.edu.unbosque.urbike.bicicletaservice.entity;

import jakarta.persistence.*;

@Table(name = "bicicletas")
@Entity(name = "bicicletas")
public class Bicicleta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bicicleta")
    private Integer idBicicleta;
    @Column(name = "numero_serie")
    private String numeroSerie;
    private String tipo;
    private String estado;
    private Integer bateria;
    @Column(name = "id_estacion")
    private Integer idEstacion;

    public Bicicleta(Integer idBicicleta, String numeroSerie, String tipo, String estado, Integer bateria, Integer idEstacion) {
        this.idBicicleta = idBicicleta;
        this.numeroSerie = numeroSerie;
        this.tipo = tipo;
        this.estado = estado;
        this.bateria = bateria;
        this.idEstacion = idEstacion;
    }

    public Bicicleta() {

    }

    public Integer getIdBicicleta() {
        return idBicicleta;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public String getTipo() {
        return tipo;
    }

    public String getEstado() {
        return estado;
    }

    public Integer getBateria() {
        return bateria;
    }

    public Integer getidEstacion() {
        return idEstacion;
    }
}
