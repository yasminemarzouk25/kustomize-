package tn.esprit.gestionevenement.gestionevenement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.gestionevenement.gestionevenement.entities.Commentaires;

public interface CommentairesRepository extends JpaRepository<Commentaires, Integer> {
}