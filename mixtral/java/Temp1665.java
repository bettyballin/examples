import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Temp1665 {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository repository;

    public boolean authenticate(String email, String rawPassword) {
        Optional<User> optional = repository.findByEmail(email);

        if (!optional.isPresent())
            return false;

        User user = optional.get();

        // Compare provided password with stored hashed version
        boolean isValid = passwordEncoder.matches(rawPassword, user.getPassword());

        if (isValid) {
            return true;
        } else {
            throw new BadCredentialsException("Invalid username or password.");
        }
    }

    public static void main(String[] args) {
        // This is just a placeholder to prevent compilation error.
        // Actual execution and testing should be done in a Spring Boot application context.
    }
}

interface UserRepository {
    Optional<User> findByEmail(String email);
}

class User {
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}