package co.edu.unbosque.urbike.bicicletaservice.service;

import co.edu.unbosque.urbike.bicicletaservice.client.TelemetriaClient;
import co.edu.unbosque.urbike.bicicletaservice.entity.Estacion;
import co.edu.unbosque.urbike.bicicletaservice.model.response.CoordenadasDTO;
import co.edu.unbosque.urbike.bicicletaservice.repository.EstacionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class EstacionService {

    private final EstacionRepository estacionRepo;
    private final TelemetriaClient telemetriaClient;

    public EstacionService(EstacionRepository estacionRepo, TelemetriaClient telemetriaClient) {
        this.estacionRepo = estacionRepo;
        this.telemetriaClient = telemetriaClient;
    }

    public int obtenerEstacionNombre(String nombre) {
        return estacionRepo.getEstacionsByNombre(nombre).get(0).getIdEstacion();
    }

    public String obtenerEstacionNombreById(Integer id_estacion) {
        return estacionRepo.findById(id_estacion).get().getNombre();
    }

    public String obtenerEstacionTipoById(Integer id_estacion) {
        return estacionRepo.findById(id_estacion).get().getCategoria();
    }

    public List<Estacion> listarTodasLasEstaciones() {
        return estacionRepo.findAll();
    }

    public Boolean compararEstacionBicicleta(Integer idBicicleta, Integer idEstacion) {
        CoordenadasDTO bicicleta = telemetriaClient.obtenerCoordenadas(idBicicleta);
        Estacion estacion = estacionRepo.findById(idEstacion).get();

        return Objects.equals(bicicleta.latitud(), estacion.getLatitud()) && Objects.equals(bicicleta.longitud(), estacion.getLongitud());
    }

}
