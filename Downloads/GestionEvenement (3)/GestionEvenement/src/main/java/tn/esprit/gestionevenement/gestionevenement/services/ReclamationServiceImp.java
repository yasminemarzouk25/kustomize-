package tn.esprit.gestionevenement.gestionevenement.services;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import tn.esprit.gestionevenement.gestionevenement.entities.Reclamation;
import tn.esprit.gestionevenement.gestionevenement.entities.User;
import tn.esprit.gestionevenement.gestionevenement.exceptions.ResourceNotFoundException;
import tn.esprit.gestionevenement.gestionevenement.repositories.ReclamationRepository;
import tn.esprit.gestionevenement.gestionevenement.repositories.UserRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class ReclamationServiceImp implements IReclamation{
    ReclamationRepository reclamationRepository ;
    UserRepository userRepository ;
    @Override
    public Reclamation addReclamation(Reclamation reclamation) {
        return reclamationRepository.save(reclamation);
    }

    @Override
    public ResponseEntity<Reclamation> updateReclamation(Integer id, Reclamation reclamation) {
        Reclamation reclamation1 = reclamationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Reclamation not exist with id :" + id));
        reclamation1.setTitre(reclamation.getTitre());
        reclamation1.setContenu(reclamation.getContenu());
        reclamationRepository.save(reclamation1);
        return ResponseEntity.ok(reclamation1);
    }

    @Override
    public ResponseEntity<Reclamation> retrieveReclamationById(Integer id) {
        Reclamation reclamation = reclamationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Reclamation not exist with id :" + id));

        return ResponseEntity.ok(reclamation);
    }

    @Override
    public List<Reclamation> retrieveAllReclamation() {
        return reclamationRepository.findAll();
    }

    @Override
    public ResponseEntity<HttpStatus> deleteReclamationById(Integer id) {
        Reclamation reclamation = reclamationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Reclamation not exist with id :" + id));
        reclamationRepository.delete(reclamation);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public Reclamation addReclamationAndasignToUser(Reclamation rec, Integer idUser) {
        User user = userRepository.findById(idUser).orElseThrow(() -> new ResourceNotFoundException("User not exist with id :" + idUser));
        rec.setUser(user);
        return reclamationRepository.save(rec);
    }

}
