package tn.esprit.gestionevenement.gestionevenement.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import tn.esprit.gestionevenement.gestionevenement.entities.Logistique;

import java.util.List;

public interface ILogistique {
    Logistique addLogistique(Logistique logistique);
    ResponseEntity<Logistique> updateLogistique (Integer id , Logistique logistique);
    ResponseEntity<Logistique> retrieveLogistiqueById (Integer id);
    List<Logistique> retrieveAllLogistique();
    ResponseEntity<HttpStatus> deleteLogistiqueById(Integer id);
    Logistique addLogistiqueAndasignToUser (Logistique logistique, Integer idUser) ;

    }
