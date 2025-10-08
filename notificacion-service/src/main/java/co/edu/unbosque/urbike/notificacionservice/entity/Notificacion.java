package co.edu.unbosque.urbike.notificacionservice.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Table(name = "notificaciones" )
@Entity(name = "notificaciones")
public class Notificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_notificacion")
    private Integer idNotificacion;
    @Column(name = "id_usuario")
    private Integer idUsuario;
    private String mensaje;
    private String tipo;
    @Column(name = "fecha_envio")
    private Timestamp fechaEnvio;
    private String estado;

    public Notificacion(Integer idNotificacion, Integer idUsuario, String mensaje, String tipo, Timestamp fechaEnvio, String estado) {
        this.idNotificacion = idNotificacion;
        this.idUsuario = idUsuario;
        this.mensaje = mensaje;
        this.tipo = tipo;
        this.fechaEnvio = fechaEnvio;
        this.estado = estado;
    }
    public Notificacion() {

    }

    public Integer getIdNotificacion() {
        return idNotificacion;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public String getMensaje() {
        return mensaje;
    }

    public String getTipo() {
        return tipo;
    }

    public Timestamp getFechaEnvio() {
        return fechaEnvio;
    }

    public String getEstado() {
        return estado;
    }
}
