package co.edu.unbosque.urbike.viajeservice.client;

import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange("/urbike/v1/usuario")
public interface UsuarioClient {
    @GetExchange("/validate")
    Integer obtenerIdUsuarioToken(@RequestHeader("Authorization") String token);
}
