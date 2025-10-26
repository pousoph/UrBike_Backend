package co.edu.unbosque.urbike.bicicletaservice.client;

import co.edu.unbosque.urbike.bicicletaservice.model.response.CoordenadasDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange("/urbike/v1/telemetria")
public interface TelemetriaClient {

    @GetExchange("/{idBicicleta}")
    CoordenadasDTO obtenerCoordenadas(@PathVariable Integer idBicicleta);
}
