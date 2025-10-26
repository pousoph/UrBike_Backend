package co.edu.unbosque.urbike.pagoservice.client;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PutExchange;

@HttpExchange("/urbike/v1/usuario")
public interface UsuarioClient {

    @PutExchange("/saldo")
    String recargarSaldo(@RequestHeader("Authorization") String token, @RequestParam Integer idUsuario, @RequestBody Double amount);
}
