package tn.esprit.gestionevenement.gestionevenement.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import tn.esprit.gestionevenement.gestionevenement.entities.Event;
import tn.esprit.gestionevenement.gestionevenement.entities.Logistique;

import java.util.List;

public interface IEvent {
    Event addEvent(Event event);
    ResponseEntity<Event> updateEvent (Integer id , Event event );
    ResponseEntity<Event> retrieveEventById (Integer id);
    List<Event> retrieveAllEvent();
    ResponseEntity<HttpStatus> deleteEventById(Integer id);
    Event addEventeAndasignToUser (Event event,  Integer idUser) ;

    }
