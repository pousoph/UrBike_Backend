package co.edu.unbosque.urbike.viajeservice.model.response;

import java.sql.Timestamp;

public record FacturaDTO(Integer idUsuario,
                         String nombre,
                         String numeroSerie,
                         String estacionInicio,
                         String estacionFinal,
                         Timestamp fechaInicio,
                         Timestamp fechaFinal,
                         Float tarifaBase,
                         Integer minutosExtra,
                         Float costoExtra,
                         Float total) {
}