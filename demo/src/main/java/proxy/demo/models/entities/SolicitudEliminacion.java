package proxy.demo.models.entities;

import proxy.demo.models.Enums.EstadoSolicitud;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
public class SolicitudEliminacion {
    private UUID id;
    private String fundamento;
    private EstadoSolicitud aceptacion;
    private Hecho hecho;

    public SolicitudEliminacion(String fundamento, Hecho hecho, EstadoSolicitud aceptacion){
        this.hecho = hecho;
        this.fundamento = fundamento;
        this.aceptacion = aceptacion;
    }

    public void aceptar(){
        this.setAceptacion(EstadoSolicitud.ACEPTADO);
    }
    public void rechazado(){
        this.setAceptacion(EstadoSolicitud.RECHAZADO);
    }
}
