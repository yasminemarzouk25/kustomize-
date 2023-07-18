package tn.esprit.gestionevenement.gestionevenement.services;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.esprit.gestionevenement.gestionevenement.entities.Event;
import tn.esprit.gestionevenement.gestionevenement.entities.Postes;
import tn.esprit.gestionevenement.gestionevenement.entities.Projet;
import tn.esprit.gestionevenement.gestionevenement.exceptions.ResourceNotFoundException;
import tn.esprit.gestionevenement.gestionevenement.repositories.EventRepository;
import tn.esprit.gestionevenement.gestionevenement.repositories.ProjetRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class ProjetServiceImp implements IProjet{
    ProjetRepository projetRepository;
    EventRepository eventRepository ;
    @Override
    public Projet addProjet(Projet projet) {
        return projetRepository.save(projet);
    }

    @Override
    public ResponseEntity<Projet> updateProjet(Integer id, Projet projet) {
        Projet projet1 = projetRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Projet not exist with id :" + id));
        projet1.setTitre(projet.getTitre());
        projet1.setContenu(projet.getContenu());
        projetRepository.save(projet1);
        return ResponseEntity.ok(projet1);
    }

    @Override
    public ResponseEntity<Projet> retrieveProjetById(Integer id) {
        Projet projet = projetRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Projet not exist with id :" + id));

        return ResponseEntity.ok(projet);
    }

    @Override
    public List<Projet> retrieveAllProjet() {
        return projetRepository.findAll();
    }

    @Override
    public ResponseEntity<HttpStatus> deleteProjetById(Integer id) {
        Projet projet = projetRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Projet not exist with id :" + id));
        projetRepository.delete(projet);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public Projet addProjetAndasignToEvent(Projet projet, Integer idEvent) {
        Event event = eventRepository.findById(idEvent).orElseThrow(() -> new ResourceNotFoundException("Event not exist with id :" + idEvent));
        projet.setEvent(event);
        return projetRepository.save(projet);
    }
}
