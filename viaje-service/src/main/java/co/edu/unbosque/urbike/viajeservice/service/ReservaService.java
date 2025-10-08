package co.edu.unbosque.urbike.viajeservice.service;

import co.edu.unbosque.urbike.viajeservice.client.BicicletaClient;
import co.edu.unbosque.urbike.viajeservice.client.UsuarioClient;
import co.edu.unbosque.urbike.viajeservice.entity.Reserva;
import co.edu.unbosque.urbike.viajeservice.entity.Viaje;
import co.edu.unbosque.urbike.viajeservice.model.request.BicicletaDTO;
import co.edu.unbosque.urbike.viajeservice.model.request.ReservaDTO;
import co.edu.unbosque.urbike.viajeservice.model.response.CreatedResponseDTO;
import co.edu.unbosque.urbike.viajeservice.repository.ReservaRepository;
import co.edu.unbosque.urbike.viajeservice.repository.ViajeRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class ReservaService {
    private ReservaRepository reservaRepo;
    private ViajeRepository viajeRepo;
    private BicicletaClient bicicletaClient;
    private UsuarioClient usuarioClient;

    public ReservaService(ReservaRepository reservaRepo, ViajeRepository viajeRepo, BicicletaClient bicicletaClient, UsuarioClient usuarioClient) {
        this.reservaRepo = reservaRepo;
        this.viajeRepo = viajeRepo;
        this.bicicletaClient = bicicletaClient;
        this.usuarioClient = usuarioClient;
    }

    public CreatedResponseDTO createReserva(String token, ReservaDTO newReserva) {
        Integer idUsuario = usuarioClient.obtenerIdUsuarioToken(token);

        BicicletaDTO bicicletaDTO = bicicletaClient.obtenerBicicletaReserva(newReserva.id_bicicleta());

        Viaje v = viajeRepo.save(new Viaje(
                null,
                idUsuario,
                bicicletaDTO.id_bicicleta(),
                newReserva.id_estacion_inicio(),
                newReserva.id_estacion_final(),
                null,
                null,
                0F,
                0,
                0F,
                0F
        ));


        Reserva r = reservaRepo.save(new Reserva(
                null, idUsuario, newReserva.id_bicicleta(), v.getIdViaje(),
                Timestamp.valueOf(LocalDateTime.now()), Timestamp.valueOf(LocalDateTime.now().plusMinutes(10)), "ACTIVA"
        ));
        return new CreatedResponseDTO(bicicletaClient.obtenerEstacion(bicicletaDTO.id_estacion()), bicicletaDTO.tipo(), bicicletaDTO.id_bicicleta());
    }
}
