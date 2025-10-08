package co.edu.unbosque.urbike.notificacionservice.repository;

import co.edu.unbosque.urbike.notificacionservice.entity.Notificacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificacionRepository extends JpaRepository<Notificacion, Integer> {
}
