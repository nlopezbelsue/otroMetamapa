package proxy.demo.models.repositories;

import org.springframework.stereotype.Repository;
import proxy.demo.models.Enums.Origen;
import proxy.demo.models.entities.Categoria;
import proxy.demo.models.entities.Hecho;
import proxy.demo.models.entities.Ubicacion;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class HechoRepository {
    private final List<Hecho> hechos = new ArrayList<>();

    public HechoRepository() {
        this.hechos.add(new Hecho(
                UUID.randomUUID(),
                Origen.FUENTE_DINAMICA,
                "Incendio forestal en Córdoba",
                "Bomberos trabajaron horas para contener un incendio de gran magnitud.",
                new Categoria("clima"),
                new Ubicacion(-31.4123, -64.1812),
                LocalDateTime.now().minusDays(10)
        ));

        this.hechos.add(new Hecho(
                UUID.randomUUID(),
                Origen.FUENTE_DINAMICA,
                "Viento Zonda en Mendoza",
                "Ráfagas fuertes provocaron caída de postes y baja visibilidad.",
                new Categoria("clima"),
                new Ubicacion(-32.8895, -68.8458),
                LocalDateTime.now().minusDays(8)
        ));

        this.hechos.add(new Hecho(
                UUID.randomUUID(),
                Origen.FUENTE_DINAMICA,
                "Inundación en La Plata",
                "Lluvias intensas causaron anegamientos en varios barrios.",
                new Categoria("clima"),
                new Ubicacion(-34.9212, -57.9545),
                LocalDateTime.now().minusDays(7)
        ));
    }

    public List<Hecho> findAll() {
        return hechos;
    }

    public Optional<Hecho> findById(UUID id) {
        return hechos.stream().filter(h -> h.getId().equals(id)).findFirst();
    }

    public Hecho save(Hecho hecho) {
        hechos.add(hecho);
        return hecho;
    }
}
