package co.edu.unbosque.urbike.usuarioservice.service;

import co.edu.unbosque.urbike.usuarioservice.entity.Usuario;
import co.edu.unbosque.urbike.usuarioservice.model.request.LoginDTO;
import co.edu.unbosque.urbike.usuarioservice.model.request.RegistroDTO;
import co.edu.unbosque.urbike.usuarioservice.model.response.InicioSesionDTO;
import co.edu.unbosque.urbike.usuarioservice.repository.UsuarioRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final TokenService tokenService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthService(UsuarioRepository usuarioRepository, TokenService tokenService, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.usuarioRepository = usuarioRepository;
        this.tokenService = tokenService;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    public String registrarUsuario(RegistroDTO registro) {
        usuarioRepository.save(
                new Usuario(
                        null,
                        registro.nombre(),
                        registro.correo(),
                        passwordEncoder.encode(registro.contrasena()),
                        false,
                        "BASICO",
                        0F,
                        Timestamp.valueOf(LocalDateTime.now()),
                        "SALDO"
                )
        );

        return "Usuario registrado con exito, Bienvenido " + registro.nombre() + " :D";
    }

    public InicioSesionDTO iniciarSesion(LoginDTO login) {
        Authentication authToken = new UsernamePasswordAuthenticationToken(login.correo(), login.contrasena());
        var authUser = authenticationManager.authenticate(authToken);
        var tokenJWT = tokenService.generateToken((Usuario) authUser.getPrincipal());

        Usuario usuario = (Usuario) authUser.getPrincipal();

        return new InicioSesionDTO(
                tokenJWT,
                usuario.getNombre(),
                usuario.getSaldo()
        );
    }

    public Integer obtenerIdUsuarioToken(String token) {
        return tokenService.getIdUsuario(token);
    }

}
