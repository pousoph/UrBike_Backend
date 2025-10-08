package co.edu.unbosque.urbike.usuarioservice.controller;

import co.edu.unbosque.urbike.usuarioservice.model.request.LoginDTO;
import co.edu.unbosque.urbike.usuarioservice.model.request.RegistroDTO;
import co.edu.unbosque.urbike.usuarioservice.service.AuthService;
import co.edu.unbosque.urbike.usuarioservice.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/urbike/v1/usuario")
public class UsuarioController {
    private UsuarioService usuarioService;
    private AuthService authService;

    public UsuarioController(UsuarioService usuarioService, AuthService authService) {
        this.usuarioService = usuarioService;
        this.authService = authService;
    }

    @PostMapping("/registro")
    public ResponseEntity<?> registro(@RequestBody @Valid RegistroDTO registro){
        return ResponseEntity.status(HttpStatus.CREATED).body(authService.registrarUsuario(registro));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid LoginDTO login){
        return ResponseEntity.accepted().body(authService.iniciarSesion(login));
    }

    @GetMapping("/validate")
    public ResponseEntity<?> obtenerIdUsuarioToken(@RequestHeader("Authorization") String token) {
        token = token.substring(7);
        return ResponseEntity.status(HttpStatus.CREATED).body(authService.obtenerIdUsuarioToken(token));
    }
}
