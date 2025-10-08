package co.edu.unbosque.urbike.bicicletaservice.repository;

import co.edu.unbosque.urbike.bicicletaservice.entity.Bicicleta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BicicletaRepository extends JpaRepository<Bicicleta, Integer> {
    List<Bicicleta> findByIdEstacion(Integer idEstacion);
}
