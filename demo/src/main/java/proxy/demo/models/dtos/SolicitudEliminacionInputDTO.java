package proxy.demo.models.dtos;

import proxy.demo.models.Enums.EstadoSolicitud;
import lombok.Data;

import java.util.UUID;

@Data
public class SolicitudEliminacionInputDTO {
    private String fundamento;
    private EstadoSolicitud aceptacion;
//    private UUID idUsuario;
    private Integer idHecho;
}
