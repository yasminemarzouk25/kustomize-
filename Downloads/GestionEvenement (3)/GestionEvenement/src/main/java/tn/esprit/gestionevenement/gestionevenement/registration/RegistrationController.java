package tn.esprit.gestionevenement.gestionevenement.registration;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000/api/v1/signup")
@RestController
@RequestMapping(path = "/api/v1/")
@AllArgsConstructor
public class RegistrationController {
    private final RegistrationService registrationService ;
    @PostMapping(path = "signup")
    public String register (@RequestBody RegistrationRequest request) {
        return registrationService.register(request);
    }
    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }
}
