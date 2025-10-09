package co.edu.unbosque.urbike.viajeservice.service;

import co.edu.unbosque.urbike.viajeservice.client.BicicletaClient;
import co.edu.unbosque.urbike.viajeservice.client.UsuarioClient;
import co.edu.unbosque.urbike.viajeservice.entity.Reserva;
import co.edu.unbosque.urbike.viajeservice.entity.Viaje;
import co.edu.unbosque.urbike.viajeservice.model.response.FacturaDTO;
import co.edu.unbosque.urbike.viajeservice.model.request.FinViajeDTO;
import co.edu.unbosque.urbike.viajeservice.repository.ReservaRepository;
import co.edu.unbosque.urbike.viajeservice.repository.ViajeRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDateTime;

@Service
public class ViajeService {
    private final ViajeRepository viajeRepo;
    private final ReservaRepository reservaRepo;
    private final BicicletaClient bicicletaClient;
    private final UsuarioClient usuarioClient;

    public ViajeService(ViajeRepository viajeRepo, ReservaRepository reservaRepo, BicicletaClient bicicletaClient, UsuarioClient usuarioClient) {
        this.viajeRepo = viajeRepo;
        this.reservaRepo = reservaRepo;
        this.bicicletaClient = bicicletaClient;
        this.usuarioClient = usuarioClient;
    }

    public Boolean iniciarViaje(String numero_serie) {
        Integer idBicicleta = bicicletaClient.obtenerIdBicicletaXSerial(numero_serie);
        Reserva r = reservaRepo.findAllByIdBicicleta((idBicicleta)).get(reservaRepo.findAllByIdBicicleta((idBicicleta)).size()-1);
        if (r.getFechaExpira().before(Timestamp.valueOf(LocalDateTime.now()))) {
            r.setEstado("EXPIRADA");
            return false;
        }
        Viaje v = viajeRepo.findById(r.getIdViaje()).get();
        String estacionInicio = bicicletaClient.obtenerEstacionTipoById(v.getEstacionInicio());
        String estacionFinal = bicicletaClient.obtenerEstacionTipoById(v.getEstacionFin());
        float tarifaBase = 0F;
        if (estacionInicio.equals("METRO") && (estacionFinal.equals("RESIDENCIAL") || estacionFinal.equals("CENTRO_FINANCIERO"))) {
            tarifaBase = 17500F;
        } else if ((estacionInicio.equals("RESIDENCIAL") || estacionInicio.equals("CENTRO_FINANCIERO")) && (estacionFinal.equals("METRO"))) {
            tarifaBase = 25000F;
        }
        v.setTarifaBase(tarifaBase);
        v.setFechaInicio(Timestamp.valueOf(LocalDateTime.now()));
        return true;
        //TODO ESTADO DE CANDADO UNLOCKED DESPUES DE PREGUNTAR
    }

    public FacturaDTO finViaje(FinViajeDTO finViajeDTO) {
        Viaje v = viajeRepo.findAllByEstacionFin(finViajeDTO.idEstacion()).get(viajeRepo.findAllByEstacionFin(finViajeDTO.idEstacion()).size()-1);
        Reserva r = reservaRepo.findByIdViaje(v.getIdViaje());

        int minutosExtra, maxMinutos = 0;
        float costoAdicional = 0F;

        if (v.getTarifaBase() == 17500F) {
            maxMinutos = 45;
            costoAdicional = 250F;
        } else if (v.getTarifaBase() == 25000F) {
            maxMinutos = 75;
            costoAdicional = 250F;
        }

        long total = Duration.between(v.getFechaFin().toLocalDateTime(), v.getFechaInicio().toLocalDateTime()).toMinutes();
        minutosExtra = Math.toIntExact(Math.max(0, total - maxMinutos));

        costoAdicional *= minutosExtra;

        return new FacturaDTO(
                v.getIdUsuario(),
                usuarioClient.nombreUsuario(v.getIdUsuario()),
                bicicletaClient.obtenerBicicletaReserva(r.getIdBicicleta()).numeroSerie(),
                bicicletaClient.obtenerEstacion(v.getEstacionInicio()),
                bicicletaClient.obtenerEstacion(v.getEstacionFin()),
                v.getFechaInicio(),
                v.getFechaFin(),
                v.getTarifaBase(),
                minutosExtra,
                costoAdicional,
                v.getTarifaBase() + costoAdicional
        );
    }


}
