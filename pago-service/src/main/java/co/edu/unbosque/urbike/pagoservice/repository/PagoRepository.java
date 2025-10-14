package co.edu.unbosque.urbike.pagoservice.repository;

import co.edu.unbosque.urbike.pagoservice.entity.Pago;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagoRepository extends JpaRepository<Pago,String>{
}
