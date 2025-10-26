package co.edu.unbosque.urbike.iotservice.controller;

import co.edu.unbosque.urbike.iotservice.model.response.CoordenadasDTO;
import co.edu.unbosque.urbike.iotservice.service.TelemetriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/urbike/v1/telemetria")
public class TelemetriaController {
    private final TelemetriaService telemetriaService;

    public TelemetriaController(TelemetriaService telemetriaService){
        this.telemetriaService = telemetriaService;
    }

    @GetMapping("/{idBicicleta}")
    public ResponseEntity<CoordenadasDTO> obtenerCoordenadas(@PathVariable Integer idBicicleta){
        return ResponseEntity.ok(telemetriaService.obtenerCoordenadasBicicleta(idBicicleta));
    }

}
