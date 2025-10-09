package co.edu.unbosque.urbike.bicicletaservice.service;

import co.edu.unbosque.urbike.bicicletaservice.entity.Bicicleta;
import co.edu.unbosque.urbike.bicicletaservice.model.response.BicicletaDTO;
import co.edu.unbosque.urbike.bicicletaservice.repository.BicicletaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BicicletaService {

    private final BicicletaRepository bicicletaRepo;
    private final EstacionService estacionServ;

    public BicicletaService(BicicletaRepository bicicletaRepo, EstacionService estacionServ) {
        this.bicicletaRepo = bicicletaRepo;
        this.estacionServ = estacionServ;
    }

    public List<Bicicleta> obtenerBicicletaEstacion(String nombre) {
        int id_estacion = estacionServ.obtenerEstacionNombre(nombre);
        return bicicletaRepo.findByIdEstacion(id_estacion);

    }

    public BicicletaDTO getBicicletaById(Integer id_bicicleta) {
        Optional<Bicicleta> bicicleta = bicicletaRepo.findById(id_bicicleta);
        return bicicleta.map(value -> new BicicletaDTO(value.getIdBicicleta(), value.getNumeroSerie(), value.getTipo(), value.getEstado(), value.getidEstacion())).orElse(null);
    }

    public Integer getIdXSerialBicicleta(String numero_serie) {
        return bicicletaRepo.findByNumeroSerie(numero_serie).getIdBicicleta();
    }


}
