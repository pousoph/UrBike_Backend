package co.edu.unbosque.urbike.notificacionservice.model.request;

public record CorreoDTO(
        Integer id_usuario,
        String correo,
        String asunto,
        String mensaje
) {
}
