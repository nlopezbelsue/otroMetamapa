package proxy.demo.services;

import proxy.demo.models.Enums.EstadoSolicitud;
import proxy.demo.models.dtos.HechoOutputDTO;
import proxy.demo.models.dtos.SolicitudEliminacionInputDTO;
import proxy.demo.models.dtos.SolicitudEliminacionOutputDTO;
import proxy.demo.models.entities.SolicitudEliminacion;
import proxy.demo.shared.RespuestaHTTP;

import java.util.List;

public interface ISolicitudEliminacionService {
    List<SolicitudEliminacionOutputDTO> findall();
    SolicitudEliminacionOutputDTO crearSolicitudEliminacion(SolicitudEliminacionInputDTO solicitud);
    RespuestaHTTP<SolicitudEliminacionOutputDTO> crearSolicitudesEliminacion();
//    SolicitudEliminacionOutputDTO revisarSolicitud(UUID id, SolicitudEliminacionInputDTO solicitud);
    SolicitudEliminacionOutputDTO solicitudOutputDTO(SolicitudEliminacion solicitudEliminacion);
//    List<SolicitudEliminacionOutputDTO> obtenerSolicitudPorHecho(UUID idHecho);
}
