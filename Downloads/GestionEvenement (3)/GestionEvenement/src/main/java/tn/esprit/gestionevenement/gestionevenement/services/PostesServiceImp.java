package tn.esprit.gestionevenement.gestionevenement.services;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.esprit.gestionevenement.gestionevenement.entities.Postes;
import tn.esprit.gestionevenement.gestionevenement.entities.Reclamation;
import tn.esprit.gestionevenement.gestionevenement.entities.User;
import tn.esprit.gestionevenement.gestionevenement.exceptions.ResourceNotFoundException;
import tn.esprit.gestionevenement.gestionevenement.repositories.PostesRepository;
import tn.esprit.gestionevenement.gestionevenement.repositories.UserRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class PostesServiceImp implements IPostes{
    PostesRepository postesRepository;
    UserRepository userRepository;
    @Override
    public Postes addPostes(Postes postes) {
        return postesRepository.save(postes);
    }

    @Override
    public ResponseEntity<Postes> updatePostes(Integer id, Postes postes) {
        Postes postes1 = postesRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post not exist with id :" + id));
        postes1.setTitre(postes.getTitre());
        postes1.setContenu(postes.getContenu());
        postesRepository.save(postes1);
        return ResponseEntity.ok(postes1);
    }

    @Override
    public ResponseEntity<Postes> retrievePostesById(Integer id) {
        Postes postes = postesRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post not exist with id :" + id));

        return ResponseEntity.ok(postes);
    }

    @Override
    public List<Postes> retrieveAllPostes() {
        return postesRepository.findAll();
    }

    @Override
    public ResponseEntity<HttpStatus> deletePostesById(Integer id) {
        Postes postes = postesRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Postes not exist with id :" + id));
        postesRepository.delete(postes);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public Postes addPostesAndasignToUser(Postes postes, Integer idUser) {
        User user = userRepository.findById(idUser).orElseThrow(() -> new ResourceNotFoundException("User not exist with id :" + idUser));
        postes.setUser(user);
        return postesRepository.save(postes);

    }
}
