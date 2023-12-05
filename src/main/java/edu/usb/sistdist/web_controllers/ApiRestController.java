package edu.usb.sistdist.web_controllers;

import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author PunkerGhoul
 */
@RestController
@RequestMapping("/api")
public class ApiRestController {

    @GetMapping()
    @ResponseBody
    public Object get() {
        Map<String, Object> object = new HashMap<>();
        object.put("Nombre", "API Sistemas Distribuidos");
        object.put("Descripción", "Ejemplo funcionamiento backend");
        object.put("Versión", "0.1");
        return object;
    }
}
