package co.edu.unbosque.urbike.usuarioservice.model.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public record RegistroDTO(
        @NotNull(message = "El nombre no puede estar vacio") String nombre,
        @Email(message = "No es un correo valido") String correo,
        @Length(min = 8, message = "La contraseña es muy corta, debe tener 8 caracteres como minimo") String contrasena
) {
}
