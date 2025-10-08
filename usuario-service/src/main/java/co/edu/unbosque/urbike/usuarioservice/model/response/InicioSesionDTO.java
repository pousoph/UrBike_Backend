package co.edu.unbosque.urbike.usuarioservice.model.response;

public record InicioSesionDTO(
        String token,
        String nombre,
        Float saldo
        //String plan
) {
}
