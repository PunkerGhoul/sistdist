package edu.usb.sistdist.repositories;

import edu.usb.sistdist.entities.Equipos;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author PunkerGhoul
 */
@Repository
public interface EquiposRepository extends JpaRepository<Equipos, Integer> {
    
    //Optional<Equipos> findByNombreEquipo(String nombre);
    
}
