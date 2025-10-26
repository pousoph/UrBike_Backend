package co.edu.unbosque.urbike.iotservice.repository;

import co.edu.unbosque.urbike.iotservice.entity.Telemetria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelemetriaRepository extends JpaRepository<Telemetria, Integer> {
    Telemetria findByIdBicicleta(Integer idBicicleta);
}
