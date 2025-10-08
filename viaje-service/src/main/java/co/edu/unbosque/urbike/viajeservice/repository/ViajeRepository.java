package co.edu.unbosque.urbike.viajeservice.repository;

import co.edu.unbosque.urbike.viajeservice.entity.Viaje;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ViajeRepository extends JpaRepository<Viaje, Integer> {
}
