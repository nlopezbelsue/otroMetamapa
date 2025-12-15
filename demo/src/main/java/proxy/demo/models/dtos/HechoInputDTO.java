package proxy.demo.models.dtos;

import proxy.demo.models.Enums.EstadoRevision;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
public class HechoInputDTO {
    private String nombre;
    private String descripcion;
    private String categoria;
    private List<String> fotos;
    private LocalDateTime fechaAcontecimiento;
    private LocalDateTime fechaDeCarga;
    private Double latitud;
    private Double longitud;
    private UUID usuario;
    private EstadoRevision estadoRevision;

}
