package co.edu.unbosque.urbike.viajeservice.client;

import co.edu.unbosque.urbike.viajeservice.entity.Reserva;
import co.edu.unbosque.urbike.viajeservice.model.request.BicicletaDTO;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange("/urbike/v1/bicicleta")
public interface BicicletaClient {

    @GetExchange
    BicicletaDTO obtenerBicicletaReserva(@RequestParam Integer id_bicicleta);

    @GetExchange("/estacion")
    String obtenerEstacion(@RequestParam Integer id_estacion);

    @GetExchange("/id-bici-serial")
    Integer obtenerIdBicicletaXSerial(@RequestParam String numero_serie);

    @GetExchange("/estacion")
    String obtenerEstacionTipoById(@RequestParam Integer id_estacion);

}
