package tn.esprit.gestionevenement.gestionevenement.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import tn.esprit.gestionevenement.gestionevenement.entities.Postes;
import tn.esprit.gestionevenement.gestionevenement.entities.Projet;

import java.util.List;

public interface IPostes {
    Postes addPostes(Postes postes);
    ResponseEntity<Postes> updatePostes (Integer id , Postes postes );
    ResponseEntity<Postes> retrievePostesById (Integer id);
    List<Postes> retrieveAllPostes();
    ResponseEntity<HttpStatus> deletePostesById(Integer id);
    Postes addPostesAndasignToUser (Postes postes, Integer idUser) ;

    }
