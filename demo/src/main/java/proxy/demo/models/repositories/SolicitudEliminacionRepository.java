package proxy.demo.models.repositories;

import org.springframework.stereotype.Repository;
import proxy.demo.models.entities.SolicitudEliminacion;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class SolicitudEliminacionRepository {
    private final List<SolicitudEliminacion> solicitudes = new ArrayList<>();

    public List<SolicitudEliminacion> findAll() {
        return solicitudes;
    }

    public Optional<SolicitudEliminacion> findById(Integer id) {
        return solicitudes.stream().filter(s -> s.getId().equals(id)).findFirst();
    }

    public SolicitudEliminacion save(SolicitudEliminacion solicitud) {
        solicitudes.add(solicitud);
        return solicitud;
    }
}
