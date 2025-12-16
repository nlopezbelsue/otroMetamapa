package proxy.demo.services.impl;

import proxy.demo.models.Enums.EstadoRevision;
import proxy.demo.models.Enums.EstadoSolicitud;
import proxy.demo.models.Enums.Origen;
import proxy.demo.models.dtos.HechoInputDTO;
import proxy.demo.models.dtos.HechoOutputDTO;
import proxy.demo.models.entities.*;
import proxy.demo.models.repositories.HechoRepository;
//import proxy.demo.models.repositories.ISolicitudEliminacionRepository;
import proxy.demo.services.IHechoService;
import proxy.demo.shared.RespuestaHTTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class HechoService implements IHechoService {

    @Autowired
    private HechoRepository hechoRepository;
//    @Autowired
//    private ISolicitudEliminacionRepository solicitudEliminacionRepository;

    @Override
    public List<HechoOutputDTO> getAllHechos() {
        return hechoRepository.findAll()
                .stream()
                .map(this::hechoOutputDTO)
                .toList();
    }

    private HechoOutputDTO hechoOutputDTO(Hecho hecho) {
        HechoOutputDTO dto = new HechoOutputDTO();
        dto.setId(hecho.getId());
        dto.setNombre(hecho.getTitulo());
        dto.setDescripcion(hecho.getDescripcion());
        dto.setCategoria(hecho.getCategoria().getNombre());
        dto.setFechaAcontecimiento(hecho.getFechaAcontecimiento());
        dto.setFechaDeCarga(hecho.getFechaDeCarga());
        dto.setLatitud(hecho.getUbicacion().getLatitud());
        dto.setLongitud(hecho.getUbicacion().getLongitud());
        dto.setEstadoRevision(hecho.getEstadoRevision());
        dto.setOrigen(hecho.getOrigen());
        dto.setPais(hecho.getUbicacion().getPais());
        dto.setProvincia(hecho.getUbicacion().getProvincia());
        List<String> fotos = new ArrayList<> ();
        dto.setFotos(fotos);
        return dto;
    }

    @Override
    public RespuestaHTTP<HechoOutputDTO> crearHechos() {

        // == HECHO 1 ==
        Hecho h1 = new Hecho(
                1,
                Origen.FUENTE_DINAMICA,
                "Incendio forestal en Córdoba",
                "Bomberos trabajaron horas para contener un incendio de gran magnitud.",
                new Categoria("clima"),
                new Ubicacion(-31.4123, -64.1812),
                LocalDateTime.now().minusDays(10)
        );
        hechoRepository.save(h1);

        // == HECHO 2 ==
        Hecho h2 = new Hecho(
                2,
                Origen.FUENTE_DINAMICA,
                "Viento Zonda en Mendoza",
                "Ráfagas fuertes provocaron caída de postes y baja visibilidad.",
                new Categoria("clima"),
                new Ubicacion(-32.8895, -68.8458),
                LocalDateTime.now().minusDays(8)
        );
        hechoRepository.save(h2);

        // == HECHO 3 ==
        Hecho h3 = new Hecho(
                3,
                Origen.FUENTE_DINAMICA,
                "Inundación en La Plata",
                "Lluvias intensas causaron anegamientos en varios barrios.",
                new Categoria("clima"),
                new Ubicacion(-34.9212, -57.9545),
                LocalDateTime.now().minusDays(7)
        );
        hechoRepository.save(h3);

        // == HECHO 4 ==
        Hecho h4 = new Hecho(
                4,
                Origen.FUENTE_DINAMICA,
                "Granizo en Rosario",
                "Tormenta con granizo afectó a múltiples vehículos.",
                new Categoria("clima"),
                new Ubicacion(-32.9587, -60.6939),
                LocalDateTime.now().minusDays(5)
        );
        hechoRepository.save(h4);

        // == HECHO 5 ==
        Hecho h5 = new Hecho(
                5,
                Origen.FUENTE_DINAMICA,
                "Nieve en Bariloche",
                "Fuertes nevadas cerraron caminos de montaña.",
                new Categoria("clima"),
                new Ubicacion(-41.1335, -71.3103),
                LocalDateTime.now().minusDays(4)
        );
        hechoRepository.save(h5);

        // == HECHO 6 ==
        Hecho h6 = new Hecho(
                6,
                Origen.FUENTE_DINAMICA,
                "Tormenta eléctrica en Salta",
                "Varias zonas afectadas con cortes de luz.",
                new Categoria("clima"),
                new Ubicacion(-24.7821, -65.4232),
                LocalDateTime.now().minusDays(3)
        );
        hechoRepository.save(h6);

        // == HECHO 7 ==
        Hecho h7 = new Hecho(
                7,
                Origen.FUENTE_DINAMICA,
                "Ola de calor en Buenos Aires",
                "Temperaturas superiores a 38° durante tres días.",
                new Categoria("clima"),
                new Ubicacion(-34.6037, -58.3816),
                LocalDateTime.now().minusDays(2)
        );
        hechoRepository.save(h7);

        // == HECHO 8 ==
        Hecho h8 = new Hecho(
                8,
                Origen.FUENTE_DINAMICA,
                "Fuerte temporal en Mar del Plata",
                "Vientos y lluvias intensas provocaron caída de árboles.",
                new Categoria("clima"),
                new Ubicacion(-38.0055, -57.5426),
                LocalDateTime.now().minusDays(6)
        );
        hechoRepository.save(h8);

        // == HECHO 9 ==
        Hecho h9 = new Hecho(
                9,
                Origen.FUENTE_DINAMICA,
                "Nevada en Ushuaia",
                "Acumulación de nieve causó demoras en rutas.",
                new Categoria("clima"),
                new Ubicacion(-54.8019, -68.3029),
                LocalDateTime.now().minusDays(9)
        );
        hechoRepository.save(h9);

        // == HECHO 10 ==
        Hecho h10 = new Hecho(
                10,
                Origen.FUENTE_DINAMICA,
                "Tornado leve en Chaco",
                "Vientos intensos provocaron voladuras de techos.",
                new Categoria("clima"),
                new Ubicacion(-27.4512, -58.9867),
                LocalDateTime.now().minusDays(12)
        );
        hechoRepository.save(h10);

        return new RespuestaHTTP<>(hechoOutputDTO(h10), HttpStatus.CREATED.value());
    }




//    @Override
//    public RespuestaHTTP<Void> eliminarHecho(UUID id) {
//        Hecho hechoAEliminar = hechoRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Hecho no encontrado con ID: " + id));
//
//        for (Coleccion c : hechoAEliminar.getColecciones()) {
//            c.getHechos().remove(hechoAEliminar);
//        }
//
//        hechoRepository.delete(hechoAEliminar);
//
//        return new RespuestaHTTP<>(null, HttpStatus.OK.value());
//    }


    @Override
    public HechoOutputDTO getHechoPorId(Integer id) {
        Hecho hecho = hechoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hecho no encontrado con ID: " + id));

        return hechoOutputDTO(hecho);
    }


}


