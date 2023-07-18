package tn.esprit.gestionevenement.gestionevenement.services;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.esprit.gestionevenement.gestionevenement.entities.Logistique;
import tn.esprit.gestionevenement.gestionevenement.entities.Projet;
import tn.esprit.gestionevenement.gestionevenement.entities.User;
import tn.esprit.gestionevenement.gestionevenement.exceptions.ResourceNotFoundException;
import tn.esprit.gestionevenement.gestionevenement.repositories.LogistiqueRepository;
import tn.esprit.gestionevenement.gestionevenement.repositories.UserRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class LogistiqueServiceImp implements ILogistique{
    LogistiqueRepository logistiqueRepository;
    UserRepository userRepository;
    @Override
    public Logistique addLogistique(Logistique logistique) {
        return logistiqueRepository.save(logistique);
    }

    @Override
    public ResponseEntity<Logistique> updateLogistique(Integer id, Logistique logistique) {
        Logistique logistique1 = logistiqueRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Logistique not exist with id :" + id));
        logistique1.setTypeLogistique(logistique.getTypeLogistique());
        logistiqueRepository.save(logistique1);

        return ResponseEntity.ok(logistique1);
    }

    @Override
    public ResponseEntity<Logistique> retrieveLogistiqueById(Integer id) {
        Logistique logistique = logistiqueRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Logistique not exist with id :" + id));

        return ResponseEntity.ok(logistique);
    }

    @Override
    public List<Logistique> retrieveAllLogistique() {
        return logistiqueRepository.findAll();
    }

    @Override
    public ResponseEntity<HttpStatus> deleteLogistiqueById(Integer id) {
        Logistique logistique = logistiqueRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Logistique not exist with id :" + id));
        logistiqueRepository.delete(logistique);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public Logistique addLogistiqueAndasignToUser(Logistique logistique, Integer idUser) {
        User user = userRepository.findById(idUser).orElseThrow(() -> new ResourceNotFoundException("User not exist with id :" + idUser));
        logistique.setUser(user);
        return logistiqueRepository.save(logistique);
    }
}
