package tn.esprit.gestionevenement.gestionevenement.restControllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestionevenement.gestionevenement.entities.FeedBack;
import tn.esprit.gestionevenement.gestionevenement.entities.Reclamation;
import tn.esprit.gestionevenement.gestionevenement.services.IFeedBack;

import java.util.List;
@RestController
@AllArgsConstructor

public class FeedBackRestController {
    IFeedBack iFeedBack;
    @PostMapping("/addFeedBack")
    public FeedBack addFeedBack(@RequestBody FeedBack feedBack){
        return iFeedBack.addFeedBack(feedBack);
    }
    @PutMapping("/updateFeedBack/{id}")
    public ResponseEntity<FeedBack> updateFeedBack (@PathVariable Integer id , @RequestBody FeedBack feedBack){
        return iFeedBack.updateFeedBack(id ,feedBack);
    }
    @GetMapping("/retrieveFeedBackById/{id}")
    public ResponseEntity<FeedBack> retrieveFeedBackById (@PathVariable("id") Integer id){
        return iFeedBack.retrieveFeedBackById(id);
    }
    @GetMapping("/getAllFeedBack")
    public List<FeedBack> retrieveAllFeedBack(){
        return iFeedBack.retrieveAllFeedBack();
    }

    @DeleteMapping("/deleteFeedBackById/{id}")
    public ResponseEntity<HttpStatus> deleteFeedBackById(@PathVariable ("id") Integer id){
        return iFeedBack.deleteFeedBackById(id);
    }
    @PostMapping("/addFeedBackAndasignToUser/{idUser}")
    public FeedBack addFeedBackAndasignToUser (@RequestBody FeedBack feed, @PathVariable("idUser") Integer idUser) {
        return  iFeedBack.addFeedBackAndasignToUser(feed,idUser);}
}
