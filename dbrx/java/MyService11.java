import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class MyService {

    @Autowired
    private UserRepository userRepository;

    @PreAuthorize("hasRole('ROLE_USER') and #id == authentication.principal.id")
    public User getUserById(Long id, @AuthenticationPrincipal Authentication authentication) {
        return userRepository.findById(id).orElse(null);
    }
}

interface UserRepository {
    Optional<User> findById(Long id);
}

class User {
    private Long id;
    // other fields, getters, setters, etc.
}