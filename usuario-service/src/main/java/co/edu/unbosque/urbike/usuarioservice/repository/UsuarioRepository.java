package co.edu.unbosque.urbike.usuarioservice.repository;

import co.edu.unbosque.urbike.usuarioservice.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    UserDetails findByCorreo(String username);
}
