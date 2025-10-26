package co.edu.unbosque.urbike.pagoservice.model.request;

import co.edu.unbosque.urbike.pagoservice.entity.Currency;

public record RecargarSaldoDTO(
        Integer idUsuario,
        Double amount,
        Currency currency,
        String stripeEmail,
        String stripeToken
) {
}
