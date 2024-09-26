import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.rememberme.AuthenticationTrustResolver;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthCheckController {

    @Autowired
    private AuthenticationTrustResolver authenticationTrustResolver;

    @GetMapping("/isLoggedIn")
    public ResponseEntity<Boolean> isUserLoggedIn(@RequestParam("username") String username) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        boolean isAuthenticated = authentication.isAuthenticated() && !authenticationTrustResolver.isAnonymous(authentication);

        return new ResponseEntity<>(isAuthenticated, HttpStatus.OK);
    }
}