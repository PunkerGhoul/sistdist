package edu.usb.sistdist.services;

import edu.usb.sistdist.entities.Equipos;
import edu.usb.sistdist.repositories.EquiposRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author PunkerGhoul
 */
@Service
public class EquiposService {

    @Autowired
    private EquiposRepository equiposRepository;

    public List<Equipos> findAll() {
        return equiposRepository.findAll();
    }

    public Optional<Equipos> findById(int idEquipo) {
        return equiposRepository.findById(idEquipo);
    }

    public void deleteById(int idEquipo) {
        equiposRepository.delete(equiposRepository.getReferenceById(idEquipo));
    }

    public Equipos save(Equipos equipo) {
        return equiposRepository.save(equipo);
    }
}
