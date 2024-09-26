import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Entity
class User {
    // Example fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Credentials credentials;

    // Getters and setters
}

@Embeddable
class Credentials {
    private String username;
    private String email;
    
    // Getters and setters
}

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByCredentials_Username(String username);
    Boolean existsByCredentials_Email(String email);
}

@Service
class MyAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserRepository userRepo;

    //...
    public boolean checkUserExistsWithUsernameOrEmail(String username, String email) {
        return (userRepo.findByCredentials_Username(username).isPresent() ||
                userRepo.existsByCredentials_Email(email));
    }

    // Implement other methods required by AuthenticationProvider
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // Implement authentication logic
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        // Implement support logic
        return false;
    }
}