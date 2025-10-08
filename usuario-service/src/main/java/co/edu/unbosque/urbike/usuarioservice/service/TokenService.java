package co.edu.unbosque.urbike.usuarioservice.service;

import co.edu.unbosque.urbike.usuarioservice.entity.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
    @Value("$config.jwt.secret")
    private String secret;

    public TokenService(){

    }

    public String generateToken(Usuario usuario){
        Algorithm algorithm = Algorithm.HMAC256(secret);

        return JWT.create()
                .withIssuer("UrBike")
                .withSubject(usuario.getCorreo())
                .withClaim("id", usuario.getIdUsuario())
                .withExpiresAt(expirationDate())
                .sign(algorithm);
    }

    public Integer getIdUsuario(String token){
        if(token == null){
            throw new RuntimeException("Token invalido");
        }

        Algorithm algorithm = Algorithm.HMAC256(secret);
        DecodedJWT verifier = JWT.require(algorithm)
                .withIssuer("UrBike")
                .build().verify(token);

        return verifier.getClaim("id").asInt();
    }

    private Instant expirationDate(){
        return LocalDateTime.now().plusDays(1).toInstant(ZoneOffset.of("-05:00"));
    }

    public String getSubject(String token) {
        if(token == null){
            throw new RuntimeException("Token invalido");
        }

        Algorithm algorithm = Algorithm.HMAC256(secret);
        DecodedJWT verifier = JWT.require(algorithm)
                .withIssuer("UrBike")
                .build().verify(token);

        return verifier.getSubject();
    }
}
