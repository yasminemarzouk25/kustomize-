package tn.esprit.gestionevenement.gestionevenement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.gestionevenement.gestionevenement.entities.Reclamation;

public interface ReclamationRepository extends JpaRepository<Reclamation, Integer> {
}
