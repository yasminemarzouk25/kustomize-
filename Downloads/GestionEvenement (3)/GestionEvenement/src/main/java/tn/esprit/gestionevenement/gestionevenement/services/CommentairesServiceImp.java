package tn.esprit.gestionevenement.gestionevenement.services;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.esprit.gestionevenement.gestionevenement.entities.Commentaires;
import tn.esprit.gestionevenement.gestionevenement.entities.FeedBack;
import tn.esprit.gestionevenement.gestionevenement.entities.Postes;
import tn.esprit.gestionevenement.gestionevenement.entities.User;
import tn.esprit.gestionevenement.gestionevenement.exceptions.ResourceNotFoundException;
import tn.esprit.gestionevenement.gestionevenement.repositories.CommentairesRepository;
import tn.esprit.gestionevenement.gestionevenement.repositories.PostesRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class CommentairesServiceImp implements ICommentaires{
    CommentairesRepository commentairesRepository;
    PostesRepository postesRepository;
    @Override
    public Commentaires addCommentaires(Commentaires commentaires) {
        return commentairesRepository.save(commentaires);
    }

    @Override
    public ResponseEntity<Commentaires> updateCommentaires(Integer id, Commentaires commentaires) {
        Commentaires commentaires1 = commentairesRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("commentaire not exist with id :" + id));
        commentaires1.setTitre(commentaires.getTitre());
        commentaires1.setContenu(commentaires.getContenu());
        commentairesRepository.save(commentaires1);
        return ResponseEntity.ok(commentaires1);
    }

    @Override
    public ResponseEntity<Commentaires> retrieveCommentairesById(Integer id) {
        Commentaires commentaires = commentairesRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Commentaires not exist with id :" + id));
        return ResponseEntity.ok(commentaires);
    }

    @Override
    public List<Commentaires> retrieveAllCommentaires() {
        return commentairesRepository.findAll();
    }

    @Override
    public ResponseEntity<HttpStatus> deleteCommentairesById(Integer id) {
        Commentaires commentaires = commentairesRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Commentaires not exist with id :" + id));
        commentairesRepository.delete(commentaires);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public Commentaires addCommentairesAndasignToPost(Commentaires commentaires, Integer idPost) {
        Postes postes = postesRepository.findById(idPost).orElseThrow(() -> new ResourceNotFoundException("Post not exist with id :" + idPost));
        commentaires.setPost(postes);
        return commentairesRepository.save(commentaires);
    }
}
