package proxy.demo.services;

import proxy.demo.models.dtos.HechoInputDTO;
import proxy.demo.models.dtos.HechoOutputDTO;
import proxy.demo.shared.RespuestaHTTP;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface IHechoService {
    List<HechoOutputDTO> getAllHechos();
    RespuestaHTTP<HechoOutputDTO> crearHechos();
    HechoOutputDTO getHechoPorId(Integer id);
}