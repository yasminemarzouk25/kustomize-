package tn.esprit.gestionevenement.gestionevenement.restControllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestionevenement.gestionevenement.entities.Event;
import tn.esprit.gestionevenement.gestionevenement.entities.Logistique;
import tn.esprit.gestionevenement.gestionevenement.services.IEvent;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/")
public class EventRestController {
    IEvent iEvent;
    @PostMapping("addEvent")
    public Event addEvent(@RequestBody Event event){
        return iEvent.addEvent(event);
    }
    @PutMapping("/updateEvent/{id}")
    public ResponseEntity<Event> updateEvent (@PathVariable Integer id , @RequestBody Event event){
        return iEvent.updateEvent(id ,event);
    }
    @GetMapping("/retrieveEventById/{id}")
    public ResponseEntity<Event> retrieveEventById (@PathVariable("id") Integer id){
        return iEvent.retrieveEventById(id);
    }
    @GetMapping("getallevent")
    public List<Event> retrieveAllEvent(){
        return iEvent.retrieveAllEvent();
    }

    @DeleteMapping("/deleteEventId/{id}")
    public ResponseEntity<HttpStatus> deleteEventById(@PathVariable ("id") Integer id){
        return iEvent.deleteEventById(id);
    }
    @PostMapping("/addEventAndasignToUser/{idUser}")
    public Event addEventeAndasignToUser (@RequestBody Event event, @PathVariable("idUser") Integer idUser) {
        return  iEvent.addEventeAndasignToUser(event , idUser);}
}
