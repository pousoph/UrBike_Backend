package co.edu.unbosque.urbike.bicicletaservice.repository;

import co.edu.unbosque.urbike.bicicletaservice.entity.Estacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EstacionRepository extends JpaRepository<Estacion, Integer> {

    @Query("SELECT e FROM estaciones e WHERE e.nombre = ?1")
    List<Estacion> getEstacionsByNombre(String nombre);
}
