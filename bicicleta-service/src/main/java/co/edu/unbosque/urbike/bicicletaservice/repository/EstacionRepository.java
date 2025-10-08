package co.edu.unbosque.urbike.bicicletaservice.repository;

import co.edu.unbosque.urbike.bicicletaservice.entity.Estacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EstacionRepository extends JpaRepository<Estacion, Integer> {
    List<Estacion> getEstacionsByNombre(String nombre);
}
