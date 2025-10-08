package co.edu.unbosque.urbike.viajeservice.controller;

import co.edu.unbosque.urbike.viajeservice.entity.Reserva;
import co.edu.unbosque.urbike.viajeservice.model.request.ReservaDTO;
import co.edu.unbosque.urbike.viajeservice.service.ReservaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/urbike/v1/viaje")
public class ReservaController {

    private final ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @PostMapping("/reserva")
    public ResponseEntity<?> crearReserva(@RequestHeader("Authorization") String token, @RequestBody ReservaDTO reservaDTO) {
        return ResponseEntity.ok(reservaService.createReserva(token, reservaDTO));
    }
}
