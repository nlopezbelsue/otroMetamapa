package proxy.demo.services.impl;

import org.springframework.http.HttpStatus;
import proxy.demo.Interfaces.DetectorDeSpam;
import proxy.demo.models.Enums.EstadoRevision;
import proxy.demo.models.Enums.EstadoSolicitud;
import proxy.demo.models.Enums.Origen;
import proxy.demo.models.dtos.HechoOutputDTO;
import proxy.demo.models.dtos.SolicitudEliminacionInputDTO;
import proxy.demo.models.dtos.SolicitudEliminacionOutputDTO;
import proxy.demo.models.entities.*;
import proxy.demo.models.repositories.HechoRepository;
import proxy.demo.models.repositories.SolicitudEliminacionRepository;
//import proxy.demo.models.repositories.UsuarioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proxy.demo.services.ISolicitudEliminacionService;
import proxy.demo.shared.RespuestaHTTP;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class SolicitudEliminacionService implements ISolicitudEliminacionService {

    @Autowired
    private SolicitudEliminacionRepository solicitudEliminacionRepository;
//    @Autowired
//    private UsuarioRepository usuarioRepository;
    @Autowired
    private HechoRepository hechoRepository;
    @Autowired
    private DetectorDeSpam detectorDeSpam;


    @Override
    public List<SolicitudEliminacionOutputDTO> findall() {
        return this.solicitudEliminacionRepository
                .findAll()
                .stream()
                .map(this::solicitudOutputDTO)
                .toList();
    }

    @Override
    public SolicitudEliminacionOutputDTO solicitudOutputDTO(SolicitudEliminacion solicitudEliminacion) {
        SolicitudEliminacionOutputDTO solicitudEliminacionOutputDTO = new SolicitudEliminacionOutputDTO();
        solicitudEliminacionOutputDTO.setId(solicitudEliminacion.getId());
        solicitudEliminacionOutputDTO.setAceptacion(solicitudEliminacion.getAceptacion());
        solicitudEliminacionOutputDTO.setFundamento(solicitudEliminacion.getFundamento());
        return solicitudEliminacionOutputDTO;
    }

    @Override
    public SolicitudEliminacionOutputDTO crearSolicitudEliminacion(SolicitudEliminacionInputDTO input) {

        if (input.getFundamento() == null || input.getFundamento().length() < 500) {
            throw new RuntimeException("El fundamento debe tener al menos 500 caracteres.");
        }

        Hecho hecho = hechoRepository.findById(input.getIdHecho())
                .orElseThrow(() -> new RuntimeException("Hecho no encontrado con ID: " + input.getIdHecho()));


        EstadoSolicitud estado;

        if (detectorDeSpam.esSpam(input.getFundamento())) {
            estado = EstadoSolicitud.RECHAZADO;
        } else {
            estado = EstadoSolicitud.PENDIENTE;
        }


        SolicitudEliminacion solicitud = new SolicitudEliminacion(
                input.getFundamento(),
                hecho,
                estado
        );

        solicitud.setId(UUID.randomUUID());

        solicitudEliminacionRepository.save(solicitud);

        return solicitudOutputDTO(solicitud);
    }

//    @Override
//    public RespuestaHTTP<SolicitudEliminacionOutputDTO> crearSolicitudesEliminacion() {
//
//        // === SOLICITUD 1 ===
//        Hecho hecho1 = hechoRepository.findById(1)
//                .orElseThrow(() -> new RuntimeException("Hecho no encontrado con ID 1"));
//
//        SolicitudEliminacion s1 = new SolicitudEliminacion(
//                "El hecho contiene información incorrecta.",
//                hecho1,
//                EstadoSolicitud.PENDIENTE
//        );
//        s1.setId(1);
//        solicitudEliminacionRepository.save(s1);
//
//        // === SOLICITUD 2 ===
//        Hecho hecho3 = hechoRepository.findById(3)
//                .orElseThrow(() -> new RuntimeException("Hecho no encontrado con ID 3"));
//
//        SolicitudEliminacion s2 = new SolicitudEliminacion(
//                "La persona involucrada pidió que se elimine el registro.",
//                hecho3,
//                EstadoSolicitud.PENDIENTE
//        );
//        s2.setId(2);
//        solicitudEliminacionRepository.save(s2);
//
//        // === SOLICITUD 3 ===
//        Hecho hecho5 = hechoRepository.findById(5)
//                .orElseThrow(() -> new RuntimeException("Hecho no encontrado con ID 5"));
//
//        SolicitudEliminacion s3 = new SolicitudEliminacion(
//                "Duplicado de otro hecho similar.",
//                hecho5,
//                EstadoSolicitud.PENDIENTE
//        );
//        s3.setId(3);
//        solicitudEliminacionRepository.save(s3);
//
//        return new RespuestaHTTP<>(solicitudOutputDTO(s3), HttpStatus.CREATED.value());
//    }

//    private Integer generarNuevoId() {
//        return solicitudEliminacionRepository.findAll()
//                .stream()
//                .mapToInt(SolicitudEliminacion::getId)
//                .max()
//                .orElse(0) + 1;
//    }


}
