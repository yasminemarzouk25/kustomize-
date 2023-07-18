package tn.esprit.gestionevenement.gestionevenement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.gestionevenement.gestionevenement.entities.FeedBack;

public interface FeedBackRepository extends JpaRepository<FeedBack, Integer> {
}
