package co.edu.unbosque.urbike.viajeservice.client;

import co.edu.unbosque.urbike.viajeservice.model.response.UsuarioSaldoDTO;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange("/urbike/v1/usuario")
public interface UsuarioClient {
    @GetExchange("/validate")
    UsuarioSaldoDTO obtenerIdUsuarioToken(@RequestHeader("Authorization") String token);
    @GetExchange("/nombre-usuario")
    String nombreUsuario (@RequestParam Integer idUsuario);
}
