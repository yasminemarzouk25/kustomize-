package tn.esprit.gestionevenement.gestionevenement.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import tn.esprit.gestionevenement.gestionevenement.entities.Cible;
import tn.esprit.gestionevenement.gestionevenement.entities.Projet;

import java.util.List;

public interface ICible {
    Cible addCible(Cible cible);
    ResponseEntity<Cible> updateCible (Integer id , Cible cible);
    ResponseEntity<Cible> retrieveCibleById (Integer id);
    List<Cible> retrieveAllCible();
    ResponseEntity<HttpStatus> deleteCibleById(Integer id);
    Cible addCibleAndasignToEvent (Cible cible,  Integer idEvent) ;

    }
