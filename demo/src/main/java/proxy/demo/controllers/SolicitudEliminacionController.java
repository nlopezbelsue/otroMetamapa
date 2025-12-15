package proxy.demo.controllers;

import proxy.demo.models.Enums.EstadoSolicitud;
import proxy.demo.models.dtos.HechoOutputDTO;
import proxy.demo.models.dtos.SolicitudEliminacionInputDTO;
import proxy.demo.models.dtos.SolicitudEliminacionOutputDTO;
import proxy.demo.services.ISolicitudEliminacionService;
import org.springframework.web.bind.annotation.*;
import proxy.demo.shared.RespuestaHTTP;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/solicitudes")
public class SolicitudEliminacionController {
    private final ISolicitudEliminacionService solicitudEliminacionService;

    public SolicitudEliminacionController(ISolicitudEliminacionService solicitudEliminacionService) {
        this.solicitudEliminacionService = solicitudEliminacionService;
    }

    @GetMapping
    public List<SolicitudEliminacionOutputDTO> getAllSolicitud() {
        return solicitudEliminacionService.findall();
    }

//    @GetMapping("/hecho/{idHecho}")
//    public List<SolicitudEliminacionOutputDTO> obtenerSolicitudPorHecho(@PathVariable UUID idHecho) {
//        return solicitudEliminacionService.obtenerSolicitudPorHecho(idHecho);
//    }

    @PostMapping
    public SolicitudEliminacionOutputDTO newSolicitudEliminacion(@RequestBody SolicitudEliminacionInputDTO solicitudInputDTO){
        return solicitudEliminacionService.crearSolicitudEliminacion(solicitudInputDTO);
    }

    @PostMapping("/solicitudes-prueba")
    public RespuestaHTTP<SolicitudEliminacionOutputDTO> newSolicitudEliminacion(){
        return solicitudEliminacionService.crearSolicitudesEliminacion();
    }

//    @PutMapping("/revision/{id}")
//    public SolicitudEliminacionOutputDTO revisarSolicitud(@PathVariable UUID id, @RequestBody SolicitudEliminacionInputDTO solicitudInputDTO) {
//        System.out.println(">>> Entré al CONTROLLER con id=" + id + ", input=" + solicitudInputDTO);
//        return solicitudEliminacionService.revisarSolicitud(id, solicitudInputDTO);
//    }

}
