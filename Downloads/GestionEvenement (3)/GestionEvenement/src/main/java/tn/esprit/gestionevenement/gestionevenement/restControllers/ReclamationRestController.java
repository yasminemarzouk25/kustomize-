package tn.esprit.gestionevenement.gestionevenement.restControllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestionevenement.gestionevenement.entities.Reclamation;
import tn.esprit.gestionevenement.gestionevenement.services.IReclamation;

import java.util.List;

@RestController
@AllArgsConstructor
public class ReclamationRestController {
    IReclamation iReclamation ;
    @PostMapping("/addReclamation")
    public Reclamation addReclamation(@RequestBody Reclamation reclamation){
        return iReclamation.addReclamation(reclamation);
    }
    @PutMapping("/updateReclamation/{id}")
    public ResponseEntity<Reclamation> updateReclamation (@PathVariable Integer id , @RequestBody Reclamation reclamation){
        return iReclamation.updateReclamation(id ,reclamation);
    }
    @GetMapping("/retrieveReclamationById/{id}")
    public ResponseEntity<Reclamation> retrieveReclamationById (@PathVariable("id") Integer id){
        return iReclamation.retrieveReclamationById(id);
    }
    @GetMapping("/getAllReclamation")
    public List<Reclamation> retrieveAllReclamation(){
        return iReclamation.retrieveAllReclamation();
    }

    @DeleteMapping("/deleteReclamationById/{id}")
    public ResponseEntity<HttpStatus> deleteReclamationById(@PathVariable ("id") Integer id){
        return iReclamation.deleteReclamationById(id);
    }
    @PostMapping("/addReclamationAndasignToUser/{idUser}")
    public Reclamation addReclamationAndasignToUser (@RequestBody Reclamation rec, @PathVariable("idUser") Integer idUser) {
        return  iReclamation.addReclamationAndasignToUser(rec,idUser);}

}
