package co.edu.unbosque.urbike.viajeservice.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Table(name = "reservas")
@Entity(name = "reservas")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva")
    private Integer idReserva;
    @Column(name = "idUsuario")
    private Integer idUsuario;
    @Column(name = "idBicicleta")
    private Integer idBicicleta;
    @Column(name = "id_viaje")
    private Integer idViaje;
    @Column(name = "fecha_reserva")
    private Timestamp fechaReserva;
    @Column(name = "fecha_expira")
    private Timestamp fechaExpira;
    private String estado;

    public Reserva(Integer idReserva, Integer idUsuario, Integer idBicicleta, Integer idViaje, Timestamp fechaReserva, Timestamp fechaExpira, String estado) {
        this.idReserva = idReserva;
        this.idUsuario = idUsuario;
        this.idBicicleta = idBicicleta;
        this.idViaje = idViaje;
        this.fechaReserva = fechaReserva;
        this.fechaExpira = fechaExpira;
        this.estado = estado;
    }

    public Reserva() {

    }

    public Integer getIdReserva() {
        return idReserva;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public Integer getIdBicicleta() {
        return idBicicleta;
    }

    public Integer getIdViaje() {
        return idViaje;
    }

    public Timestamp getFechaReserva() {
        return fechaReserva;
    }

    public Timestamp getFechaExpira() {
        return fechaExpira;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
