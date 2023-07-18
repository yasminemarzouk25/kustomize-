package tn.esprit.gestionevenement.gestionevenement.restControllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestionevenement.gestionevenement.entities.FeedBack;
import tn.esprit.gestionevenement.gestionevenement.entities.Postes;
import tn.esprit.gestionevenement.gestionevenement.repositories.PostesRepository;
import tn.esprit.gestionevenement.gestionevenement.repositories.UserRepository;
import tn.esprit.gestionevenement.gestionevenement.services.IPostes;
import tn.esprit.gestionevenement.gestionevenement.services.IUser;

import java.util.List;

@RestController
@AllArgsConstructor
public class PostRestController {
    IUser iUser ;
    IPostes iPostes;

    @PostMapping("/addPost")
    public Postes addPost(@RequestBody Postes post){
        return iPostes.addPostes(post);
    }
    @PutMapping("/updatePostes/{id}")
    public ResponseEntity<Postes> updatePostes (@PathVariable Integer id , @RequestBody Postes postes){
        return iPostes.updatePostes(id ,postes);
    }
    @GetMapping("/retrievePostesById/{id}")
    public ResponseEntity<Postes> retrievePostesById (@PathVariable("id") Integer id){
        return iPostes.retrievePostesById(id);
    }
    @GetMapping("/getAllPostes")
    public List<Postes> retrieveAllPostes(){
        return iPostes.retrieveAllPostes();
    }

    @DeleteMapping("/deletePostesById/{id}")
    public ResponseEntity<HttpStatus> deletePostesById(@PathVariable ("id") Integer id){
        return iPostes.deletePostesById(id);
    }
    @PostMapping("/addPostesAndasignToUser/{idUser}")
    public Postes addPostesAndasignToUser (@RequestBody Postes postes, @PathVariable("idUser") Integer idUser) {
        return  iPostes.addPostesAndasignToUser(postes,idUser);}

}
