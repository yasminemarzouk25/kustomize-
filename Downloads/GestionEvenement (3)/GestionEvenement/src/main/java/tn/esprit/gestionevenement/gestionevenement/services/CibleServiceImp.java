package tn.esprit.gestionevenement.gestionevenement.services;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.esprit.gestionevenement.gestionevenement.entities.Cible;
import tn.esprit.gestionevenement.gestionevenement.entities.Event;
import tn.esprit.gestionevenement.gestionevenement.exceptions.ResourceNotFoundException;
import tn.esprit.gestionevenement.gestionevenement.repositories.CibleRepository;
import tn.esprit.gestionevenement.gestionevenement.repositories.EventRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class CibleServiceImp implements ICible{
    CibleRepository cibleRepository;
    EventRepository eventRepository;
    @Override
    public Cible addCible(Cible cible) {
        return cibleRepository.save(cible);
    }

    @Override
    public ResponseEntity<Cible> updateCible(Integer id, Cible cible) {
        Cible cible1 = cibleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cible not exist with id :" + id));
        cible1.setTypeCible(cible.getTypeCible());
        cibleRepository.save(cible1);
        return ResponseEntity.ok(cible1);
    }

    @Override
    public ResponseEntity<Cible> retrieveCibleById(Integer id) {
        Cible cible = cibleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cible not exist with id :" + id));

        return ResponseEntity.ok(cible);
    }

    @Override
    public List<Cible> retrieveAllCible() {
        return cibleRepository.findAll();
    }

    @Override
    public ResponseEntity<HttpStatus> deleteCibleById(Integer id) {
        Cible cible = cibleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cible not exist with id :" + id));
        cibleRepository.delete(cible);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public Cible addCibleAndasignToEvent(Cible cible, Integer idEvent) {
        Event event = eventRepository.findById(idEvent).orElseThrow(() -> new ResourceNotFoundException("Event not exist with id :" + idEvent));
        cible.setEvent(event);
        return cibleRepository.save(cible);
    }
}
