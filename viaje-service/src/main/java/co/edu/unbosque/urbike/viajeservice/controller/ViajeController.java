package co.edu.unbosque.urbike.viajeservice.controller;

import co.edu.unbosque.urbike.viajeservice.model.request.FinViajeDTO;
import co.edu.unbosque.urbike.viajeservice.model.request.InicioViajeDTO;
import co.edu.unbosque.urbike.viajeservice.service.ViajeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/urbike/v1/viaje")
public class ViajeController {
    private final ViajeService viajeService;

    public ViajeController(ViajeService viajeService) {
        this.viajeService = viajeService;
    }

    @PostMapping("/inicio-viaje")
    public ResponseEntity<?> inicioViaje(@RequestBody InicioViajeDTO inViaje) {
        return ResponseEntity.ok(viajeService.iniciarViaje(inViaje.numeroSerie()));
    }

    @PostMapping("/fin-viaje")
    public ResponseEntity<?> finViaje(@RequestBody FinViajeDTO finViaje) {
        return ResponseEntity.ok(viajeService.finViaje(finViaje));
    }
}
