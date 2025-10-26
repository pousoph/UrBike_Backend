package co.edu.unbosque.urbike.usuarioservice.controller;

import co.edu.unbosque.urbike.usuarioservice.model.request.LoginDTO;
import co.edu.unbosque.urbike.usuarioservice.model.request.RegistroDTO;
import co.edu.unbosque.urbike.usuarioservice.service.AuthService;
import co.edu.unbosque.urbike.usuarioservice.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@CrossOrigin("*")
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
        System.out.println("entro");
        return ResponseEntity.accepted().body(authService.iniciarSesion(login));
    }

    @GetMapping("/validate")
    public ResponseEntity<?> obtenerIdUsuarioToken(@RequestHeader("Authorization") String token) {
        token = token.substring(7);
        return ResponseEntity.status(HttpStatus.CREATED).body(authService.obtenerIdUsuarioToken(token));
    }

    @GetMapping("/nombre-usuario")
    public ResponseEntity<?> obtenerNombreUsuario(@RequestParam Integer idUsuario) {
        return ResponseEntity.ok(usuarioService.getNombrexId(idUsuario));
    }
//
//    @PutMapping("/saldo")
//    public ResponseEntity<String> recargarSaldo(@RequestHeader("Authorization") String token, @RequestParam Integer idUsuario, @RequestBody Double amount){
//        token = token.substring(7);
//
//        if (Objects.equals(authService.obtenerIdUsuarioToken(token).idUsuario(), idUsuario)){
//            usuarioService.recargarSaldo(idUsuario, amount);
//            return ResponseEntity.ok("Saldo recargado");
//        }else{
//            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
//        }
//    }

}
