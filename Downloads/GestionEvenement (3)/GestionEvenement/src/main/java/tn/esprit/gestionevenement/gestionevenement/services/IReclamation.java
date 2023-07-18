package tn.esprit.gestionevenement.gestionevenement.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import tn.esprit.gestionevenement.gestionevenement.entities.Logistique;
import tn.esprit.gestionevenement.gestionevenement.entities.Reclamation;

import java.util.List;

public interface IReclamation {
    Reclamation addReclamation(Reclamation reclamation);
    ResponseEntity<Reclamation> updateReclamation (Integer id , Reclamation reclamation);
    ResponseEntity<Reclamation> retrieveReclamationById (Integer id);
    List<Reclamation> retrieveAllReclamation();
    ResponseEntity<HttpStatus> deleteReclamationById(Integer id);
    Reclamation addReclamationAndasignToUser (Reclamation rec,  Integer idUser);
}
