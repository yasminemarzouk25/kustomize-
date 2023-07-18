package tn.esprit.gestionevenement.gestionevenement.restControllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestionevenement.gestionevenement.entities.FeedBack;
import tn.esprit.gestionevenement.gestionevenement.entities.Logistique;
import tn.esprit.gestionevenement.gestionevenement.services.ILogistique;

import java.util.List;
@RestController
@AllArgsConstructor

public class LogistiqueRestController {
    ILogistique iLogistique;
    @PostMapping("/addLogistique")
    public Logistique addLogistique(@RequestBody Logistique logistique){
        return iLogistique.addLogistique(logistique);
    }
    @PutMapping("/updateLogistique/{id}")
    public ResponseEntity<Logistique> updateLogistique (@PathVariable Integer id , @RequestBody Logistique logistique){
        return iLogistique.updateLogistique(id ,logistique);
    }
    @GetMapping("/retrieveLogistiqueById/{id}")
    public ResponseEntity<Logistique> retrieveLogistiqueById (@PathVariable("id") Integer id){
        return iLogistique.retrieveLogistiqueById(id);
    }
    @GetMapping("/getAllLogistique")
    public List<Logistique> retrieveAllLogistique(){
        return iLogistique.retrieveAllLogistique();
    }

    @DeleteMapping("/deleteFLogistiqueyId/{id}")
    public ResponseEntity<HttpStatus> deleteLogistiqueById(@PathVariable ("id") Integer id){
        return iLogistique.deleteLogistiqueById(id);
    }
    @PostMapping("/addLogistiqueAndasignToUser/{idUser}")
    public Logistique addLogistiqueAndasignToUser (@RequestBody Logistique logistique, @PathVariable("idUser") Integer idUser) {
        return  iLogistique.addLogistiqueAndasignToUser(logistique,idUser);}
}
