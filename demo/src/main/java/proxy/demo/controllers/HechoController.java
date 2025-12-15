package proxy.demo.controllers;

import proxy.demo.models.dtos.HechoInputDTO;
import proxy.demo.models.dtos.HechoOutputDTO;
import proxy.demo.services.IHechoService;
import proxy.demo.shared.RespuestaHTTP;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hechos")
public class HechoController {
    private final IHechoService hechoService;

    public HechoController(IHechoService hechoService) {
        this.hechoService = hechoService;
    }

    @GetMapping
    public List<HechoOutputDTO> getAllHechos() {
        return hechoService.getAllHechos();
    }

    @PostMapping
    public RespuestaHTTP<HechoOutputDTO> crearHechos(){
        return hechoService.crearHechos();
    }

    @GetMapping("/{id}")
    public HechoOutputDTO getHechoPorId(@PathVariable Integer id) {
        return hechoService.getHechoPorId(id);
    }


}