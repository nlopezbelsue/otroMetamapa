package proxy.demo.models.dtos;

import proxy.demo.models.Enums.EstadoRevision;
import proxy.demo.models.Enums.Origen;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
public class HechoOutputDTO {
    private Integer id;
    private String nombre;
    private String descripcion;
    private String categoria;
    private List<String> fotos;
    private LocalDateTime fechaAcontecimiento;
    private LocalDateTime fechaDeCarga;
    private Double latitud;
    private Double longitud;
    private EstadoRevision estadoRevision;
    private Origen origen;
    private String pais;
    private String provincia;
    private int cantidadSolicitudesEliminacion;
}
