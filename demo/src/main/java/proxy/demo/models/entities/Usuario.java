package proxy.demo.models.entities;

import proxy.demo.models.Enums.Rol;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class Usuario {
    private UUID id;
    private String nombre;
    private String apellido;
    private String mail;
    private String password;
    private Rol rol;

    public Usuario(String nombre, String apellido, String mail, String password, Rol rol) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.mail = mail;
        this.password = password;
        this.rol = rol;
    }

    public Boolean esAdmin(){
        return rol == Rol.ADMINISTRADOR;
    }

}
