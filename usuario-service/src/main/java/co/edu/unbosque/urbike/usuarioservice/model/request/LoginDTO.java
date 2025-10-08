package co.edu.unbosque.urbike.usuarioservice.model.request;

import jakarta.validation.constraints.Email;

public record LoginDTO(
        @Email(message = "El correo no es valido") String correo,
        String contrasena
) {
}
