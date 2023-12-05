package edu.usb.sistdist.web_controllers;

import edu.usb.sistdist.dto.EnfrentamientosDTO;
import edu.usb.sistdist.entities.Enfrentamientos;
import edu.usb.sistdist.services.EnfrentamientosService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author PunkerGhoul
 */
@RestController
@RequestMapping("/api/enfrentamientos")
public class EnfrentamientosWebController {

    @Autowired
    private EnfrentamientosService enfrentamientosService;

    @GetMapping("/")
    @ResponseBody
    public Object getEnfrentamientos() {
        List<Enfrentamientos> enfrentamientosList = enfrentamientosService.findAll();
        List<Map<String, Object>> enfrentamientos = new ArrayList<>();

        for (Enfrentamientos enfrentamiento : enfrentamientosList) {
            Map<String, Object> object = new HashMap<>();
            object.put("Id", enfrentamiento.getId());
            object.put("Equipo_Local", enfrentamiento.getEquipoLocal());
            object.put("Equipo_Visitante", enfrentamiento.getEquipoVisitante());
            object.put("Fecha", enfrentamiento.getFecha());
            object.put("Resultado", enfrentamiento.getResultado());
            enfrentamientos.add(object);
        }

        return enfrentamientos;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Object get(@PathVariable String id) {
        Optional<Enfrentamientos> enfrentamiento = enfrentamientosService.findById(Integer.parseInt(id));
        Map<String, Object> responseJSON = new HashMap<>();

        enfrentamiento.ifPresentOrElse((enfrentamientoExist) -> {
            responseJSON.put("Id", enfrentamientoExist.getId());
            responseJSON.put("Equipo_Local", enfrentamientoExist.getEquipoLocal());
            responseJSON.put("Equipo_Visitante", enfrentamientoExist.getEquipoVisitante());
            responseJSON.put("Fecha", enfrentamientoExist.getFecha());
            responseJSON.put("Resultado", enfrentamientoExist.getResultado());
        }, () -> {
            responseJSON.put("Respuesta", "Enfrentamiento no encontrado");
        });
        return enfrentamiento;
    }

    @PostMapping("/")
    @ResponseBody
    public Object create(@RequestBody EnfrentamientosDTO enfrentamientosDTO) {
        Enfrentamientos nuevoEnfrentamiento = new Enfrentamientos();
        nuevoEnfrentamiento.setEquipoLocal(enfrentamientosDTO.getEquipoLocal());
        nuevoEnfrentamiento.setEquipoVisitante(enfrentamientosDTO.getEquipoVisitante());
        nuevoEnfrentamiento.setFecha(enfrentamientosDTO.getFecha());
        nuevoEnfrentamiento.setResultado(enfrentamientosDTO.getResultado());

        Enfrentamientos enfrentamientoCreado = enfrentamientosService.save(nuevoEnfrentamiento);

        Map<String, Object> responseJSON = new HashMap<>();
        responseJSON.put("Id", enfrentamientoCreado.getId());
        responseJSON.put("Respuesta", "Enfrentamiento creado exitosamente");
        return responseJSON;
    }

    @PostMapping("/{id}")
    @ResponseBody
    public Object delete(@PathVariable String id) {
        int enfrentamientoId = Integer.parseInt(id);
        Optional<Enfrentamientos> existingEnfrentamiento = enfrentamientosService.findById(enfrentamientoId);
        if (existingEnfrentamiento.isPresent()) {
            enfrentamientosService.deleteById(Integer.parseInt(id));
            Map<String, Object> responseJSON = new HashMap<>();
            responseJSON.put("Respuesta", "Enfrentamiento eliminado exitosamente");
            return responseJSON;
        }
        Map<String, Object> responseJSON = new HashMap<>();
        responseJSON.put("Respuesta", "Enfrentamiento no encontrado");
        return responseJSON;

    }

    @PutMapping("/{id}")
    @ResponseBody
    public Object updateEnfrentamiento(@PathVariable String id, @RequestBody EnfrentamientosDTO enfrentamientoDTO) {
        int enfrentamientoId = Integer.parseInt(id);
        Optional<Enfrentamientos> existingEnfrentamiento = enfrentamientosService.findById(enfrentamientoId);

        if (existingEnfrentamiento.isPresent()) {
            Enfrentamientos enfrentamientoToUpdate = existingEnfrentamiento.get();

            enfrentamientoToUpdate.setEquipoLocal(enfrentamientoDTO.getEquipoLocal());
            enfrentamientoToUpdate.setEquipoVisitante(enfrentamientoDTO.getEquipoVisitante());
            enfrentamientoToUpdate.setEquipoVisitante(enfrentamientoDTO.getEquipoVisitante());
            enfrentamientoToUpdate.setFecha(enfrentamientoDTO.getFecha());
            enfrentamientoToUpdate.setResultado(enfrentamientoDTO.getResultado());
            enfrentamientosService.save(enfrentamientoToUpdate);

            Map<String, Object> responseJSON = new HashMap<>();
            responseJSON.put("Id", enfrentamientoId);
            responseJSON.put("Respuesta", "Enfrentamiento actualizado exitosamente");
            return responseJSON;
        }
        Map<String, Object> responseJSON = new HashMap<>();
        responseJSON.put("Respuesta", "Enfrentamiento no encontrado");
        return responseJSON;
    }
}
