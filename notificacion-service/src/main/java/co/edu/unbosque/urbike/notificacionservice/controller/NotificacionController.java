package co.edu.unbosque.urbike.notificacionservice.controller;

import co.edu.unbosque.urbike.notificacionservice.model.request.CorreoDTO;
import co.edu.unbosque.urbike.notificacionservice.service.NotificacionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/urbike/v1/notificacion")
public class NotificacionController {

    private final NotificacionService notificacionService;

    public NotificacionController(NotificacionService notificacionService) {
        this.notificacionService = notificacionService;
    }

    @GetMapping
    public ResponseEntity<?> mandarCorreo(@RequestBody CorreoDTO correo){
        return ResponseEntity.ok(notificacionService.enviarEmail(correo));
    }
}
