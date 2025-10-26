package co.edu.unbosque.urbike.viajeservice.client;

import co.edu.unbosque.urbike.viajeservice.model.request.BicicletaDTO;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange("/urbike/v1/bicicleta")
public interface BicicletaClient {

    @GetExchange
    BicicletaDTO obtenerBicicletaReserva(@RequestParam("id_bicicleta") Integer id_bicicleta);

    @GetExchange("/estacion")
    String obtenerEstacion(@RequestParam("id_estacion") Integer id_estacion);

    @GetExchange("/id-bici-serial")
    Integer obtenerIdBicicletaXSerial(@RequestParam("numero_serie") String numero_serie);

    @GetExchange("/estacion/tipo")
    String obtenerEstacionTipoById(@RequestParam("id_estacion") Integer id_estacion);

    @GetExchange("/estacion/compare")
    Boolean compararEstaciones(@RequestParam("idBicicleta") Integer idBicicleta,
                               @RequestParam("idEstacion") Integer idEstacion);
}
