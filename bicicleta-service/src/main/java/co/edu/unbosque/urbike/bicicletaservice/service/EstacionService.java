package co.edu.unbosque.urbike.bicicletaservice.service;

import co.edu.unbosque.urbike.bicicletaservice.repository.EstacionRepository;
import org.springframework.stereotype.Service;

@Service
public class EstacionService {

    private EstacionRepository estacionRepo;

    public EstacionService(EstacionRepository estacionRepo) {
        this.estacionRepo = estacionRepo;
    }

    public int obtenerEstacionNombre(String nombre){
        return estacionRepo.getEstacionsByNombre(nombre).get(0).getIdEstacion();
    }
    public String obtenerEstacionNombreById(Integer id_estacion){
        return estacionRepo.findById(id_estacion).get().getNombre();
    }

}
