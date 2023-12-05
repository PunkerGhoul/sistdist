/*
 * Copyright (C) 2023 PunkerGhoul
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
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
