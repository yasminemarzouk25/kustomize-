package tn.esprit.gestionevenement.gestionevenement.services;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.esprit.gestionevenement.gestionevenement.entities.Event;
import tn.esprit.gestionevenement.gestionevenement.entities.FeedBack;
import tn.esprit.gestionevenement.gestionevenement.entities.User;
import tn.esprit.gestionevenement.gestionevenement.exceptions.ResourceNotFoundException;
import tn.esprit.gestionevenement.gestionevenement.repositories.EventRepository;
import tn.esprit.gestionevenement.gestionevenement.repositories.UserRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class EventServiceImp implements IEvent{
    EventRepository eventRepository ;
    UserRepository userRepository;
    @Override
    public Event addEvent(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public ResponseEntity<Event> updateEvent(Integer id, Event event) {
        Event event1 = eventRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Event not exist with id :" + id));
        event1.setLibelle(event.getLibelle());
        event1.setDate(event.getDate());
        event1.setObjectif(event.getObjectif());
        event1.setEnvironnement(event.getEnvironnement());
        event1.setValeur(event.getValeur());
        event1.setTypeEvent(event.getTypeEvent());
        eventRepository.save(event1);
        return ResponseEntity.ok(event1);
    }

    @Override
    public ResponseEntity<Event> retrieveEventById(Integer id) {
        Event event = eventRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Event not exist with id :" + id));


        return ResponseEntity.ok(event);
    }

    @Override
    public List<Event> retrieveAllEvent() {
        return eventRepository.findAll();
    }

    @Override
    public ResponseEntity<HttpStatus> deleteEventById(Integer id) {
        Event event = eventRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Event not exist with id :" + id));
        eventRepository.delete(event);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public Event addEventeAndasignToUser(Event event, Integer idUser) {
        User user = userRepository.findById(idUser).orElseThrow(() -> new ResourceNotFoundException("User not exist with id :" + idUser));
        event.setUser(user);
        return eventRepository.save(event);
    }
}
