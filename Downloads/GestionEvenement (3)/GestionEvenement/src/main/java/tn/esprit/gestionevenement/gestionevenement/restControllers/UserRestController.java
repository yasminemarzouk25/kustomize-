package tn.esprit.gestionevenement.gestionevenement.restControllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestionevenement.gestionevenement.entities.User;
import tn.esprit.gestionevenement.gestionevenement.services.IUser;
import tn.esprit.gestionevenement.gestionevenement.services.LoginRequest;
import tn.esprit.gestionevenement.gestionevenement.services.UserServiceImp;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/")
public class UserRestController {
    IUser iUser;
    private final UserServiceImp userServiceImp;

    @PostMapping("/addUser")
    public User addSkieur(@RequestBody User us){
        return iUser.addUser(us);
    }
    @PutMapping("/updateUser/{id}")
    public ResponseEntity<User> updateUser (@PathVariable Integer id , @RequestBody User us){
        return iUser.updateUser(id ,us);
    }
    @GetMapping("/retrieveUserById/{id}")
    public ResponseEntity<User> retrieveUserById (@PathVariable("id") Integer id){
        return iUser.retrieveUserById(id);
    }
    @GetMapping("/getAll")
    public List<User> retrieveAllUser(){
        return iUser.retrieveAllUser();
    }

    @DeleteMapping("/deleteUserById/{id}")
    public ResponseEntity<HttpStatus> deletSkieurById(@PathVariable ("id") Integer id){
        return iUser.deleteUserById(id);
    }
    @PostMapping ("login")
    public UserDetails loadUserByUsername(@RequestBody LoginRequest request) {
        return userServiceImp.loadUserByUsername(request.getEmail());
    }



}
