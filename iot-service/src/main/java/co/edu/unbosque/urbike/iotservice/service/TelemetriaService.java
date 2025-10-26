package co.edu.unbosque.urbike.iotservice.service;

import co.edu.unbosque.urbike.iotservice.entity.Telemetria;
import co.edu.unbosque.urbike.iotservice.model.response.CoordenadasDTO;
import co.edu.unbosque.urbike.iotservice.repository.TelemetriaRepository;
import org.springframework.stereotype.Service;

@Service
public class TelemetriaService {

    private TelemetriaRepository telemetriaRepository;

    public TelemetriaService(TelemetriaRepository telemetriaRepository) {
        this.telemetriaRepository = telemetriaRepository;
    }

    public CoordenadasDTO obtenerCoordenadasBicicleta(Integer idBicicleta){
        Telemetria entity = telemetriaRepository.findByIdBicicleta(idBicicleta);

        return new CoordenadasDTO(
                entity.getLatitud(),
                entity.getLongitud()
        );
    }
}
