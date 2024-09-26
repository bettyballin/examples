import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Temp2376 {

    @RequestMapping(value = "/session", method = RequestMethod.GET)
    public AuthenticatedUserDto getCurrentSession(Authentication auth) {
        if (auth == null || !auth.isAuthenticated())
            throw new BadCredentialsException("unknown session");
        return AuthenticatedUserBuilder.build(auth);
    }

    public static void main(String[] args) {
        // You can run Spring Boot application here if needed
    }
}

// Assuming AuthenticatedUserDto and AuthenticatedUserBuilder are defined elsewhere
class AuthenticatedUserDto {
    // Define fields and methods
}

class AuthenticatedUserBuilder {
    public static AuthenticatedUserDto build(Authentication auth) {
        // Build and return AuthenticatedUserDto from Authentication object
        return new AuthenticatedUserDto();
    }
}