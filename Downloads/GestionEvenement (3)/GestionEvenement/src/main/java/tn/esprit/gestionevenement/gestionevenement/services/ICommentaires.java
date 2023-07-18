package tn.esprit.gestionevenement.gestionevenement.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import tn.esprit.gestionevenement.gestionevenement.entities.Commentaires;
import tn.esprit.gestionevenement.gestionevenement.entities.Event;
import tn.esprit.gestionevenement.gestionevenement.entities.FeedBack;

import java.util.List;

public interface ICommentaires {
    Commentaires addCommentaires(Commentaires commentaires);
    ResponseEntity<Commentaires> updateCommentaires (Integer id , Commentaires commentaires );
    ResponseEntity<Commentaires> retrieveCommentairesById (Integer id);
    List<Commentaires> retrieveAllCommentaires();
    ResponseEntity<HttpStatus> deleteCommentairesById(Integer id);
    Commentaires addCommentairesAndasignToPost ( Commentaires commentaires,  Integer idPost) ;

    }
