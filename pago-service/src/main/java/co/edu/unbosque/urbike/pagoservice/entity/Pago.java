package co.edu.unbosque.urbike.pagoservice.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Table(name = "pagos")
@Entity(name = "pagos")
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pago")
    private Integer idPago;
    @Column(name = "id_usuario")
    private Integer idUsuario;
    @Column(name = "id_viaje")
    private Integer idViaje;
    private Float monto;
    private String estado;
    private String referencia;
    @Column(name = "fecha_pago")
    private Timestamp fechaPago;
    @Column(name = "metodo_pago_usado")
    private String metodoPagoUsado;
    @Column(name = "metodo_pago")
    private String metodoPago;

    public Pago() {

    }

    public Pago(Integer idPago, Integer idUsuario, Integer idViaje, Float monto, String estado, String referencia, Timestamp fechaPago, String metodoPagoUsado, String metodoPago) {
        this.idPago = idPago;
        this.idUsuario = idUsuario;
        this.idViaje = idViaje;
        this.monto = monto;
        this.estado = estado;
        this.referencia = referencia;
        this.fechaPago = fechaPago;
        this.metodoPagoUsado = metodoPagoUsado;
        this.metodoPago = metodoPago;
    }

    public Integer getIdPago() {
        return idPago;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public Integer getIdViaje() {
        return idViaje;
    }

    public Float getMonto() {
        return monto;
    }

    public String getEstado() {
        return estado;
    }

    public String getReferencia() {
        return referencia;
    }

    public Timestamp getFechaPago() {
        return fechaPago;
    }

    public String getMetodoPagoUsado() {
        return metodoPagoUsado;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setIdPago(Integer idPago) {
        this.idPago = idPago;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
