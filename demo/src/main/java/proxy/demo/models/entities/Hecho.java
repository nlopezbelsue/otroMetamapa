package proxy.demo.models.entities;

import proxy.demo.models.Enums.EstadoRevision;
import proxy.demo.models.Enums.Origen;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@NoArgsConstructor
@Getter
@Setter
public class Hecho {
    private Integer id;
    private String titulo;
    private String descripcion;
    private Categoria categoria;
    private Ubicacion ubicacion;
    private LocalDateTime fechaAcontecimiento;
    private LocalDateTime fechaDeCarga;
    private Origen origen;
    private Usuario usuario;
    private EstadoRevision estadoRevision;

    public Hecho(Origen origen, String titulo, String descripcion, Categoria categoria, Ubicacion ubicacion, LocalDateTime fechaAcontecimiento) {
        this.origen=origen;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.ubicacion = ubicacion;
        this.fechaAcontecimiento = fechaAcontecimiento;
        this.fechaDeCarga = LocalDateTime.now();
        this.estadoRevision = EstadoRevision.PENDIENTE;
    }

    public String getPais() {
        return this.ubicacion.getPais();
    }
    public String getProvincia() {
        return this.ubicacion.getProvincia();
    }
    public String getCiudad() {
        return this.ubicacion.getCiudad();
    }


    @Override
    public String toString() {
        return "Hecho{" +
                "titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", categoria='" + categoria + '\'' +
                ", ubicacion=" + (ubicacion != null ? ubicacion.toString() : "null") +
                ", fechaAcontecimiento=" + fechaAcontecimiento +
                '}';
    }
}
