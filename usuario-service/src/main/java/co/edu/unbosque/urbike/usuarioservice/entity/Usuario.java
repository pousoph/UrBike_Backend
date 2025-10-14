package co.edu.unbosque.urbike.usuarioservice.entity;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;


@Table(name = "usuarios")
@Entity(name = "usuarios")
public class Usuario implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUsuario;
    private String nombre;
    private String correo;
    private String contrasena;
    private Float saldo;
    @Column(name = "plan_actual")
    private String planActual;
    private Boolean confirmado;
    @Column(name = "fecha_registro")
    private Timestamp fechaRegistro;
    @Column(name = "metodo_pago_preferido")
    private String metodoPagoPreferido;
    @Column(name = "codigo_confirmacion")
    private String codigoConfirmacion;

    public Usuario(Integer idUsuario, String nombre, String correo, String contrasena, Float saldo, String planActual, Boolean confirmado, Timestamp fechaRegistro, String metodoPagoPreferido, String codigoConfirmacion) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
        this.saldo = saldo;
        this.planActual = planActual;
        this.confirmado = confirmado;
        this.fechaRegistro = fechaRegistro;
        this.metodoPagoPreferido = metodoPagoPreferido;
        this.codigoConfirmacion = codigoConfirmacion;
    }

    public Usuario() {

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("USUARIO"));
    }

    @Override
    public String getPassword() {
        return contrasena;
    }

    @Override
    public String getUsername() {
        return correo;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public Float getSaldo() {
        return saldo;
    }

    public String getPlanActual() {
        return planActual;
    }

    public Boolean getConfirmado() {
        return confirmado;
    }

    public Timestamp getFechaRegistro() {
        return fechaRegistro;
    }

    public String getMetodoPagoPreferido() {
        return metodoPagoPreferido;
    }

    public String getCodigoConfirmacion() {
        return codigoConfirmacion;
    }


    public void setConfirmado(Boolean confirmado) {
        this.confirmado = confirmado;
    }

    public void setMetodoPagoPreferido(String metodoPagoPreferido) {
        this.metodoPagoPreferido = metodoPagoPreferido;
    }

    public void setSaldo(Float saldo) {
        this.saldo = saldo;
    }
}
