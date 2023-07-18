package tn.esprit.gestionevenement.gestionevenement.services;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.esprit.gestionevenement.gestionevenement.entities.FeedBack;
import tn.esprit.gestionevenement.gestionevenement.entities.Reclamation;
import tn.esprit.gestionevenement.gestionevenement.entities.User;
import tn.esprit.gestionevenement.gestionevenement.exceptions.ResourceNotFoundException;
import tn.esprit.gestionevenement.gestionevenement.repositories.FeedBackRepository;
import tn.esprit.gestionevenement.gestionevenement.repositories.UserRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class FeedBackServiceImp implements IFeedBack{
    FeedBackRepository feedBackRepository;
    UserRepository  userRepository ;
    @Override
    public FeedBack addFeedBack(FeedBack feedBack) {
        return feedBackRepository.save(feedBack);
    }

    @Override
    public ResponseEntity<FeedBack> updateFeedBack(Integer id, FeedBack feedBack) {
        FeedBack feedBack1 = feedBackRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("FeedBack not exist with id :" + id));
        feedBack1.setContenu(feedBack.getContenu());
        feedBack1.setNote(feedBack.getNote());
        feedBackRepository.save(feedBack1);
        return ResponseEntity.ok(feedBack1);
    }

    @Override
    public ResponseEntity<FeedBack> retrieveFeedBackById(Integer id) {
        FeedBack feedBack = feedBackRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("FeedBack not exist with id :" + id));

        return ResponseEntity.ok(feedBack);
    }

    @Override
    public List<FeedBack> retrieveAllFeedBack() {
        return feedBackRepository.findAll();
    }

    @Override
    public ResponseEntity<HttpStatus> deleteFeedBackById(Integer id) {
        FeedBack feedBack = feedBackRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("FeedBack not exist with id :" + id));
        feedBackRepository.delete(feedBack);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public FeedBack addFeedBackAndasignToUser(FeedBack feed, Integer idUser) {
        User user = userRepository.findById(idUser).orElseThrow(() -> new ResourceNotFoundException("User not exist with id :" + idUser));
        feed.setUser(user);
        return feedBackRepository.save(feed);
    }
}
