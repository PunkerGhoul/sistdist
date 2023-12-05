package edu.usb.sistdist.web_controllers;

import edu.usb.sistdist.dto.EquiposDTO;
import edu.usb.sistdist.entities.Equipos;
import edu.usb.sistdist.services.EquiposService;
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
@RequestMapping("/api/equipos")
public class EquiposWebController {

    @Autowired
    private EquiposService equiposService;

    @GetMapping("/")
    @ResponseBody
    public Object getEquipos() {
        List<Equipos> equiposList = equiposService.findAll();
        List<Map<String, Object>> equipos = new ArrayList<>();

        for (Equipos equipo : equiposList) {
            Map<String, Object> object = new HashMap<>();
            object.put("Id", equipo.getId());
            object.put("Nombre", equipo.getNombre());
            object.put("Fundacion", equipo.getFundacion());
            object.put("Pais", equipo.getPais());
            object.put("Entrenador", equipo.getEntrenador());
            object.put("Estadio", equipo.getEstadio());
            object.put("Presupuesto", equipo.getPresupuesto());
            object.put("Puntos", equipo.getPuntos());
            equipos.add(object);
        }

        return equipos;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Object get(@PathVariable String id) {
        Optional<Equipos> equipo = equiposService.findById(Integer.parseInt(id));
        Map<String, Object> responseJSON = new HashMap<>();

        equipo.ifPresentOrElse((equipoExist) -> {
            responseJSON.put("Id", equipoExist.getId());
            responseJSON.put("Nombre", equipoExist.getNombre());
            responseJSON.put("Fundacion", equipoExist.getFundacion());
            responseJSON.put("Entrenador", equipoExist.getEntrenador());
            responseJSON.put("Estadio", equipoExist.getEstadio());
            responseJSON.put("Presupuesto", equipoExist.getPresupuesto());
            responseJSON.put("Puntos", equipoExist.getPuntos());
        }, () -> {
            responseJSON.put("Respuesta", "Enfrentamiento no encontrado");
        });
        return equipo;
    }

    @PostMapping("/")
    @ResponseBody
    public Object create(@RequestBody EquiposDTO equipoDTO) {
        Equipos nuevoEquipo = new Equipos();
        nuevoEquipo.setNombre(equipoDTO.getNombre());
        nuevoEquipo.setFundacion(equipoDTO.getFundacion());
        nuevoEquipo.setPais(equipoDTO.getPais());
        nuevoEquipo.setEntrenador(equipoDTO.getEntrenador());
        nuevoEquipo.setEstadio(equipoDTO.getEstadio());
        nuevoEquipo.setPresupuesto(equipoDTO.getPresupuesto());
        nuevoEquipo.setPuntos(equipoDTO.getPuntos());

        Equipos equipoCreado = equiposService.save(nuevoEquipo);

        Map<String, Object> responseJSON = new HashMap<>();
        responseJSON.put("Id", equipoCreado.getId());
        responseJSON.put("Respuesta", "Equipo creado exitosamente");
        return responseJSON;
    }

    @PostMapping("/{id}")
    @ResponseBody
    public Object delete(@PathVariable String id) {
        int enfrentamientoId = Integer.parseInt(id);
        Optional<Equipos> existingEnfrentamiento = equiposService.findById(enfrentamientoId);
        if (existingEnfrentamiento.isPresent()) {
            equiposService.deleteById(Integer.parseInt(id));
            Map<String, Object> responseJSON = new HashMap<>();
            responseJSON.put("Respuesta", "Equipo eliminado exitosamente");
            return responseJSON;
        }
        Map<String, Object> responseJSON = new HashMap<>();
        responseJSON.put("Respuesta", "Enfrentamiento no encontrado");
        return responseJSON;
    }

    @PutMapping("/{id}")
    @ResponseBody
    public Object updateEquipo(@PathVariable String id, @RequestBody EquiposDTO equipoDTO) {
        int equipoId = Integer.parseInt(id);
        Optional<Equipos> existingEquipo = equiposService.findById(equipoId);

        if (existingEquipo.isPresent()) {
            Equipos equipoToUpdate = existingEquipo.get();

            equipoToUpdate.setNombre(equipoDTO.getNombre());
            equipoToUpdate.setFundacion(equipoDTO.getFundacion());
            equipoToUpdate.setEntrenador(equipoDTO.getEntrenador());
            equipoToUpdate.setPais(equipoDTO.getPais());
            equipoToUpdate.setEstadio(equipoDTO.getEstadio());
            equipoToUpdate.setPresupuesto(equipoDTO.getPresupuesto());
            equipoToUpdate.setPuntos(equipoDTO.getPuntos());

            equiposService.save(equipoToUpdate);

            Map<String, Object> responseJSON = new HashMap<>();
            responseJSON.put("Id", equipoId);
            responseJSON.put("Respuesta", "Equipo actualizado exitosamente");
            return responseJSON;
        } else {
            Map<String, Object> responseJSON = new HashMap<>();
            responseJSON.put("Respuesta", "Equipo no encontrado");
            return responseJSON;
        }
    }

}
