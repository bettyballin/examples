import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomAuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/api/authenticate")
    public ResponseEntity<Boolean> authenticate(@RequestBody UsernamePasswordAuthenticationToken authRequest) {
        
        try {
            this.authenticationManager.authenticate(authRequest);
            
            // User is authenticated.
            return new ResponseEntity<>(true, HttpStatus.OK);
        } catch (BadCredentialsException e) {

            // Authentication failed.
            return new ResponseEntity<>(false, HttpStatus.UNAUTHORIZED);
        }
    }
}