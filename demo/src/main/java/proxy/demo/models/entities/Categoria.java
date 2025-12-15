package proxy.demo.models.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Categoria {
    private long id;

    private String nombre;

    public Categoria(String nombre) {
        this.nombre = nombre;
    }
}
