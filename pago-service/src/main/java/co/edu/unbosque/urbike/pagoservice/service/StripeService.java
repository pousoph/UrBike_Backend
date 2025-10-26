package co.edu.unbosque.urbike.pagoservice.service;

import co.edu.unbosque.urbike.pagoservice.client.UsuarioClient;
import co.edu.unbosque.urbike.pagoservice.entity.Pago;
import co.edu.unbosque.urbike.pagoservice.model.request.ChargeRequestDTO;
import co.edu.unbosque.urbike.pagoservice.model.request.RecargarSaldoDTO;
import co.edu.unbosque.urbike.pagoservice.model.response.InvoiceDTO;
import co.edu.unbosque.urbike.pagoservice.repository.PagoRepository;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.BalanceTransaction;
import com.stripe.model.Charge;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
public class StripeService {

    @Value("${stripe.key.private}")
    private String secretKey;

    private final PagoRepository paymentRepository;
    private final UsuarioClient usuarioClient;

    public StripeService(PagoRepository paymentRepository, UsuarioClient usuarioClient) {
        this.paymentRepository = paymentRepository;
        this.usuarioClient = usuarioClient;
    }

    @PostConstruct
    public void init() {
        Stripe.apiKey = secretKey;
    }

    public InvoiceDTO charge(ChargeRequestDTO chargeRequest) throws StripeException {
        System.out.println("Procesando...");
        System.out.println("Usuario: " + chargeRequest.idUsuario());
        System.out.println("Viaje: " + chargeRequest.idViaje());
        System.out.println("Monto recibido: " + chargeRequest.amount());
        System.out.println("Moneda: " + chargeRequest.currency());

        Map<String, Object> chargeParams = new HashMap<>();
        chargeParams.put("amount", Math.round(chargeRequest.amount() * 100));
        chargeParams.put("currency", chargeRequest.currency());
        chargeParams.put("description", chargeRequest.description());
        chargeParams.put("source", chargeRequest.stripeToken());

        Charge charge = Charge.create(chargeParams);
        System.out.println("Stripe charge creado con ID: " + charge.getId());

        String estado;
        switch (charge.getStatus()) {
            case "succeeded" -> estado = "EXITOSO";
            case "pending" -> estado = "PENDIENTE";
            case "failed" -> estado = "FALLIDO";
            default -> estado = "PENDIENTE";
        }

        //Obtener monto real desde Stripe
        BalanceTransaction balanceTx = BalanceTransaction.retrieve(charge.getBalanceTransaction());
        double montoReal = balanceTx.getAmount() / 100.0;

        Pago pago =     new Pago(
                null,
                chargeRequest.idUsuario(),
                chargeRequest.idViaje(),
                (float) montoReal,
                estado,
                charge.getId(),                     // referencia=ID del pago Stripe
                Timestamp.valueOf(LocalDateTime.now()),
                "TARJETA",
                charge.getPaymentMethod()
        );

        Pago saved = paymentRepository.save(pago);
        System.out.println("Pago guardado con ID local: " + saved.getIdPago());

        return new InvoiceDTO(
                saved.getIdPago(),
                charge.getStatus(),
                charge.getId(),
                montoReal,
                charge.getDescription(),
                charge.getPaymentMethod()
        );
    }

    public InvoiceDTO recargarSaldo(String token, RecargarSaldoDTO recargarSaldo) throws StripeException {
        Map<String, Object> chargeParams = new HashMap<>();
        chargeParams.put("amount", Math.round(recargarSaldo.amount() * 100));
        chargeParams.put("currency", recargarSaldo.currency());
        chargeParams.put("description", "Recarga de saldo en UrBike");
        chargeParams.put("source", recargarSaldo.stripeToken());

        Charge charge = Charge.create(chargeParams);

        String estado;
        switch (charge.getStatus()) {
            case "succeeded" -> estado = "EXITOSO";
            case "failed" -> estado = "FALLIDO";
            default -> estado = "PENDIENTE";
        }

        BalanceTransaction balanceTx = BalanceTransaction.retrieve(charge.getBalanceTransaction());
        double montoReal = balanceTx.getAmount() / 100.0;

        Pago pago =     new Pago(
                null,
                recargarSaldo.idUsuario(),
                null,
                (float) montoReal,
                estado,
                charge.getId(),                     // referencia=ID del pago Stripe
                Timestamp.valueOf(LocalDateTime.now()),
                "TARJETA",
                charge.getPaymentMethod()
        );

        Pago saved = paymentRepository.save(pago);

        //Actualizar saldo del usuario
        usuarioClient.recargarSaldo(token, recargarSaldo.idUsuario(), recargarSaldo.amount());

        return new InvoiceDTO(
                saved.getIdPago(),
                charge.getStatus(),
                charge.getId(),
                montoReal,
                charge.getDescription(),
                charge.getPaymentMethod()
        );
    }
}
