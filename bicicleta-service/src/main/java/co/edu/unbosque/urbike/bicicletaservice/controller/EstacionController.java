package co.edu.unbosque.urbike.bicicletaservice.controller;

import co.edu.unbosque.urbike.bicicletaservice.service.EstacionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/urbike/v1/bicicleta/estacion")
public class EstacionController {
    private final EstacionService estacionService;

    public EstacionController(EstacionService estacionService) {
        this.estacionService = estacionService;
    }

    @GetMapping
    public ResponseEntity<?> obtenerEstacion(@RequestParam Integer id_estacion) {
        return ResponseEntity.ok(estacionService.obtenerEstacionNombreById(id_estacion));
    }

    @GetMapping("/tipo")
    public ResponseEntity<?> obtenerEstacionTipoById(@RequestParam Integer id_estacion) {
        return ResponseEntity.ok(estacionService.obtenerEstacionTipoById(id_estacion));
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listarTodasLasEstaciones() {
        return ResponseEntity.ok(estacionService.listarTodasLasEstaciones());
    }

    @GetMapping("/compare")
    public ResponseEntity<?> compararEstaciones(@RequestParam Integer idBicicleta, @RequestParam Integer idEstacion) {
        return ResponseEntity.ok(estacionService.compararEstacionBicicleta(idBicicleta, idEstacion));
    }
}
