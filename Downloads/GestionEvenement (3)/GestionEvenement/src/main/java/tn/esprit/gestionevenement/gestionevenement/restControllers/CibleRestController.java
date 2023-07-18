package tn.esprit.gestionevenement.gestionevenement.restControllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestionevenement.gestionevenement.entities.Cible;
import tn.esprit.gestionevenement.gestionevenement.entities.Projet;
import tn.esprit.gestionevenement.gestionevenement.services.ICible;

import java.util.List;

@RestController
@AllArgsConstructor
public class CibleRestController {
    ICible iCible ;
    @PostMapping("/addCible")
    public Cible addCible(@RequestBody Cible cible){
        return iCible.addCible(cible);
    }
    @PutMapping("/updateCible/{id}")
    public ResponseEntity<Cible> updateCible (@PathVariable Integer id , @RequestBody Cible cible){
        return iCible.updateCible(id ,cible);
    }
    @GetMapping("/retrieveCibleById/{id}")
    public ResponseEntity<Cible> retrieveCibleById (@PathVariable("id") Integer id){
        return iCible.retrieveCibleById(id);
    }
    @GetMapping("/getAllCible")
    public List<Cible> retrieveAllCible(){
        return iCible.retrieveAllCible();
    }

    @DeleteMapping("/deleteCibleId/{id}")
    public ResponseEntity<HttpStatus> deleteCibleById(@PathVariable ("id") Integer id){
        return iCible.deleteCibleById(id);
    }
    @PostMapping("/addCibleAndasignToEvent/{idEvent}")
    public Cible addCibleAndasignToEvent (@RequestBody Cible cible, @PathVariable("idEvent") Integer idEvent) {
        return  iCible.addCibleAndasignToEvent(cible , idEvent);}
}
