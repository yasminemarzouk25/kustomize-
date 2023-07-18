package tn.esprit.gestionevenement.gestionevenement.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import tn.esprit.gestionevenement.gestionevenement.entities.FeedBack;
import tn.esprit.gestionevenement.gestionevenement.entities.Reclamation;

import java.util.List;

public interface IFeedBack {
    FeedBack addFeedBack(FeedBack feedBack);
    ResponseEntity<FeedBack> updateFeedBack (Integer id , FeedBack feedBack);
    ResponseEntity<FeedBack> retrieveFeedBackById (Integer id);
    List<FeedBack> retrieveAllFeedBack();
    ResponseEntity<HttpStatus> deleteFeedBackById(Integer id);
    FeedBack addFeedBackAndasignToUser (FeedBack feed,  Integer idUser) ;

    }
