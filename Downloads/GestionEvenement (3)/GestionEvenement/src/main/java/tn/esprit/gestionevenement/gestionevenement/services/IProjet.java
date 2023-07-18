package tn.esprit.gestionevenement.gestionevenement.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import tn.esprit.gestionevenement.gestionevenement.entities.Projet;

import java.util.List;

public interface IProjet {
    Projet addProjet(Projet projet);
    ResponseEntity<Projet> updateProjet (Integer id , Projet projet );
    ResponseEntity<Projet> retrieveProjetById (Integer id);
    List<Projet> retrieveAllProjet();
    ResponseEntity<HttpStatus> deleteProjetById(Integer id);
    Projet addProjetAndasignToEvent (Projet projet, Integer idEvent) ;

    }
