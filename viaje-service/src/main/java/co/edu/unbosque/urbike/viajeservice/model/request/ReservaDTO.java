package co.edu.unbosque.urbike.viajeservice.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ReservaDTO(@JsonProperty("id_estacion_inicio") Integer idEstacionInicio,
                         @JsonProperty("id_estacion_final") Integer idEstacionFinal,
                         @JsonProperty("id_bicicleta") Integer idBicicleta) {

}
