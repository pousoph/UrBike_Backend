package co.edu.unbosque.urbike.viajeservice.repository;

import co.edu.unbosque.urbike.viajeservice.entity.Viaje;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ViajeRepository extends JpaRepository<Viaje, Integer> {
    Viaje findByEstacionFin(Integer estacionFin);

    List<Viaje> findAllByEstacionFin(Integer estacionFin);
}
