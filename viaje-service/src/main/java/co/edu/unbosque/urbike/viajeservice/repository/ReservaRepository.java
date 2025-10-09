package co.edu.unbosque.urbike.viajeservice.repository;

import co.edu.unbosque.urbike.viajeservice.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva,Integer> {

    Reserva findByIdBicicleta(Integer idBicicleta);

    List<Reserva> findAllByIdBicicleta(Integer idBicicleta);

    Reserva findByIdViaje(Integer idViaje);
}
