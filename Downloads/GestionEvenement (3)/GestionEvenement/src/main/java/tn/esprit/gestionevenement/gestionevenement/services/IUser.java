package tn.esprit.gestionevenement.gestionevenement.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import tn.esprit.gestionevenement.gestionevenement.entities.User;

import java.util.List;

public interface IUser {
    User addUser(User sk);
    ResponseEntity<User> updateUser ( Integer id , User us );
    ResponseEntity<User> retrieveUserById (Integer id);
    List<User> retrieveAllUser();
    ResponseEntity<HttpStatus> deleteUserById(Integer id);
    String signupUser (User user);

}
