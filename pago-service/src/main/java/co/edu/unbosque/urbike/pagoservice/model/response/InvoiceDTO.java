package co.edu.unbosque.urbike.pagoservice.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record InvoiceDTO(
        Integer id,
        String status,
        @JsonProperty("charge-id") String chargeId,
        Double balance,
        String description,
        @JsonProperty("payment-method") String paymentMethod
) {
}
