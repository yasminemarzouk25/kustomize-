package tn.esprit.gestionevenement.gestionevenement.services;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import tn.esprit.gestionevenement.gestionevenement.entities.User;
import tn.esprit.gestionevenement.gestionevenement.exceptions.ResourceNotFoundException;
import tn.esprit.gestionevenement.gestionevenement.registration.token.ConfirmationToken;
import tn.esprit.gestionevenement.gestionevenement.registration.token.ConfirmationTokenService;
import tn.esprit.gestionevenement.gestionevenement.repositories.UserRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserServiceImp implements IUser , UserDetailsService {
    UserRepository userRepository;

    private final static String USER_NOT_FOUND_MSG = "user with email %s not found" ;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;
    @Override
    public User addUser(User us) {
        return userRepository.save(us);
    }

    @Override
    public ResponseEntity<User> updateUser(Integer id , User us) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not exist with id :" + id));

        user.setName(us.getName());
        user.setEmail(us.getEmail());
        user.setPwd(us.getPwd());
        userRepository.save(user);

        return ResponseEntity.ok(user);
    }

    @Override
    public ResponseEntity<User> retrieveUserById(Integer id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not exist with id :" + id));
        return ResponseEntity.ok(user) ;
    }

    @Override
    public List<User> retrieveAllUser() {
        return userRepository.findAll();
    }

    @Override
    public ResponseEntity<HttpStatus> deleteUserById(Integer id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not exist with id :" + id));
        userRepository.delete(user);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }



    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email).orElseThrow(()-> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG , email)));
    }

    public String signupUser (User user) {
        boolean userExists = userRepository.findByEmail(user.getEmail()).isPresent();
        if(userExists) {
            throw new IllegalStateException("email already taken");
        }
        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPwd(encodedPassword);
        userRepository.save(user);
        String token = UUID.randomUUID().toString();
        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                user
        );
        confirmationTokenService.saveConfirmationToken(confirmationToken);
        return token;
    }
    public int enableUser(String email) {
        return userRepository.enableUser(email);
    }
}
