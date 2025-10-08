package co.edu.unbosque.urbike.bicicletaservice.controller;

import co.edu.unbosque.urbike.bicicletaservice.service.BicicletaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/urbike/v1/bicicleta")
public class BicicletaController {

    private final BicicletaService bicicletaService;

    public BicicletaController(BicicletaService bicicletaService) {
        this.bicicletaService = bicicletaService;
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<?> obtenerBicicletaEstacion(@PathVariable String nombre) {
        return ResponseEntity.ok(bicicletaService.obtenerBicicletaEstacion(nombre));
    }

    @GetMapping
    public ResponseEntity<?> obtenerBicicletaReserva(@RequestParam Integer id_bicicleta) {
        return ResponseEntity.ok(bicicletaService.getBicicletaById(id_bicicleta));
    }
}
