import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class Temp1475 {

    private UserRepository userRepo = new UserRepository(); // Assuming UserRepository class exists
    private RightRepository rightRepo = new RightRepository(); // Assuming RightRepository class exists
    private PasswordEncoder encoder = new PasswordEncoder(); // Assuming PasswordEncoder class exists

    public static void main(String[] args) {
        // Your main application logic here
    }

    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getPrincipal() + "";
        String password = authentication.getCredentials() + "";

        User user = userRepo.findOne(username);
        if (user == null) {
            throw new BadCredentialsException("1000");
        }
        if (!encoder.matches(password, user.getPassword())) {
            throw new BadCredentialsException("1000");
        }
        if (user.isDisabled()) {
            throw new DisabledException("1001");
        }
        List<Right> userRights = rightRepo.getUserRights(username);
        return new UsernamePasswordAuthenticationToken(username, null, userRights.stream()
                .map(x -> new SimpleGrantedAuthority(x.getName()))
                .collect(Collectors.toList()));
    }
}

// Placeholder classes to make the code compile
class UserRepository {
    public User findOne(String username) {
        // Implement your method
        return null;
    }
}

class RightRepository {
    public List<Right> getUserRights(String username) {
        // Implement your method
        return null;
    }
}

class PasswordEncoder {
    public boolean matches(String rawPassword, String encodedPassword) {
        // Implement your method
        return false;
    }
}

class User {
    public String getPassword() {
        // Implement your method
        return null;
    }

    public boolean isDisabled() {
        // Implement your method
        return false;
    }
}

class Right {
    public String getName() {
        // Implement your method
        return null;
    }
}