package pad.SocialMedia.Controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pad.SocialMedia.Service.AuthService;
import pad.SocialMedia.dto.RegisterRequest;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody RegisterRequest registerRequest) {
        authService.signup(registerRequest);
        return new ResponseEntity<>("User Registration Successful",
                HttpStatus.OK);
    }

    @GetMapping("accountVerification/{token}")
    public ResponseEntity<String> verifyAccount (@PathVariable String token)
    {
        authService.verifyAccount(token);

        return new ResponseEntity<>("Account Activated!", HttpStatus.OK);
    }

}
