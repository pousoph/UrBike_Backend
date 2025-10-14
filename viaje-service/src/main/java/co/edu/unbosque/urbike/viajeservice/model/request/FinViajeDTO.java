package co.edu.unbosque.urbike.viajeservice.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public record FinViajeDTO(
        @JsonProperty("id_viaje") Integer idViaje) {
}
