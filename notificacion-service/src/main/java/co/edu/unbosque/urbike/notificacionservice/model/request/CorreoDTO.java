package co.edu.unbosque.urbike.notificacionservice.model.request;

public record CorreoDTO(
        String correo,
        String asunto,
        String mensaje
) {
}
