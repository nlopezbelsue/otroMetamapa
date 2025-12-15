package proxy.demo.shared;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RespuestaHTTP<T> {
    private T datos;
    private Integer codigo;

    public RespuestaHTTP(T datos, Integer codigo){
        this.datos = datos;
        this.codigo = codigo;
    }
}