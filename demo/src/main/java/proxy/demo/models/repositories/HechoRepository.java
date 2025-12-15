package proxy.demo.models.repositories;

import org.springframework.stereotype.Repository;
import proxy.demo.models.entities.Hecho;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class HechoRepository {
    private final List<Hecho> hechos = new ArrayList<>();

    public List<Hecho> findAll() {
        return hechos;
    }

    public Optional<Hecho> findById(Integer id) {
        return hechos.stream().filter(h -> h.getId().equals(id)).findFirst();
    }

    public Hecho save(Hecho hecho) {
        hechos.add(hecho);
        return hecho;
    }
}
