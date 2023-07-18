package tn.esprit.gestionevenement.gestionevenement.restControllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestionevenement.gestionevenement.entities.Commentaires;
import tn.esprit.gestionevenement.gestionevenement.entities.FeedBack;
import tn.esprit.gestionevenement.gestionevenement.services.ICommentaires;
import tn.esprit.gestionevenement.gestionevenement.services.IUser;

import java.util.List;

@RestController
@AllArgsConstructor
public class CommentaireRestController {
    IUser iUser;
    ICommentaires iCommentaires ;
    @PostMapping("/addCommentaires")
    public Commentaires addCommentaires(@RequestBody Commentaires commentaires){
        return iCommentaires.addCommentaires(commentaires);
    }
    @PutMapping("/updateCommentaires/{id}")
    public ResponseEntity<Commentaires> updateCommentaires (@PathVariable Integer id , @RequestBody Commentaires commentaires){
        return iCommentaires.updateCommentaires(id , commentaires);
    }
    @GetMapping("/retrieveCommentairesById/{id}")
    public ResponseEntity<Commentaires> retrieveCommentairesById (@PathVariable("id") Integer id){
        return iCommentaires.retrieveCommentairesById(id);
    }
    @GetMapping("/getAllCommentaires")
    public List<Commentaires> retrieveAllCommentaires(){
        return iCommentaires.retrieveAllCommentaires();
    }

    @DeleteMapping("/deleteCommentairesById/{id}")
    public ResponseEntity<HttpStatus> deleteCommentairesById(@PathVariable ("id") Integer id){
        return iCommentaires.deleteCommentairesById(id);
    }
    @PostMapping("/addCommentairesAndasignToPost/{idPost}")
    public Commentaires addCommentairesAndasignToPost (@RequestBody Commentaires commentaires, @PathVariable("idPost") Integer idPost) {
        return  iCommentaires.addCommentairesAndasignToPost(commentaires,idPost);}
}
