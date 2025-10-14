package co.edu.unbosque.urbike.pagoservice.model.request;

import co.edu.unbosque.urbike.pagoservice.entity.Currency;
import com.fasterxml.jackson.annotation.JsonProperty;
//Integracion solo con esto por el momento
public record ChargeRequestDTO(
        @JsonProperty("id-usuario") Integer idUsuario,
        @JsonProperty("id-viaje") Integer idViaje,
        String description,
        Double amount,
        Currency currency,
        String stripeEmail,
        String stripeToken
) {
}
