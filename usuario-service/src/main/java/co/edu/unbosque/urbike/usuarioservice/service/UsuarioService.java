package co.edu.unbosque.urbike.usuarioservice.service;

import co.edu.unbosque.urbike.usuarioservice.entity.Usuario;
import co.edu.unbosque.urbike.usuarioservice.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UsuarioService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usuarioRepository.findByCorreo(username);
    }

    public String getNombrexId(Integer idUsuario){
        return usuarioRepository.findById(idUsuario).get().getNombre();
    }

//    public void recargarSaldo(Integer idNombre, Double saldo){
//        Usuario usuario =
//    }

}
