package edu.usb.sistdist.services;

import edu.usb.sistdist.entities.Enfrentamientos;
import edu.usb.sistdist.repositories.EnfrentamientosRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author PunkerGhoul
 */
@Service
public class EnfrentamientosService {

    @Autowired
    private EnfrentamientosRepository enfrentamientosRepository;

    public List<Enfrentamientos> findAll() {
        return enfrentamientosRepository.findAll();
    }

    public Optional<Enfrentamientos> findById(int idEnfrentamiento) {
        return enfrentamientosRepository.findById(idEnfrentamiento);
    }

    public void deleteById(int idEnfrentamiento) {
        enfrentamientosRepository.delete(enfrentamientosRepository.getReferenceById(idEnfrentamiento));
    }
    
    public Enfrentamientos save(Enfrentamientos enfrentamientos) {
        return enfrentamientosRepository.save(enfrentamientos);
    }
}
