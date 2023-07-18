package tn.esprit.gestionevenement.gestionevenement.restControllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestionevenement.gestionevenement.entities.Event;
import tn.esprit.gestionevenement.gestionevenement.entities.Projet;
import tn.esprit.gestionevenement.gestionevenement.services.IProjet;

import java.util.List;

@RestController
@AllArgsConstructor
public class ProjetRestController {
    IProjet  iProjet ;
    @PostMapping("/addProjet")
    public Projet addProjet(@RequestBody Projet projet){
        return iProjet.addProjet(projet);
    }
    @PutMapping("/updateProjet/{id}")
    public ResponseEntity<Projet> updateProjet (@PathVariable Integer id , @RequestBody Projet projet){
        return iProjet.updateProjet(id ,projet);
    }
    @GetMapping("/retrieveProjetById/{id}")
    public ResponseEntity<Projet> retrieveProjetById (@PathVariable("id") Integer id){
        return iProjet.retrieveProjetById(id);
    }
    @GetMapping("/getAllProjet")
    public List<Projet> retrieveAllEvent(){
        return iProjet.retrieveAllProjet();
    }

    @DeleteMapping("/deleteProjetId/{id}")
    public ResponseEntity<HttpStatus> deleteProjetById(@PathVariable ("id") Integer id){
        return iProjet.deleteProjetById(id);
    }
    @PostMapping("/addProjetAndasignToEvent/{idEvent}")
    public Projet addProjetAndasignToEvent (@RequestBody Projet projet, @PathVariable("idEvent") Integer idEvent) {
        return  iProjet.addProjetAndasignToEvent(projet , idEvent);}
}
