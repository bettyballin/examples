import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class MyService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MySecurityService mySecurityService;

    @PreAuthorize("@mySecurityService.checkUserAccess(#id, principal)")
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}

interface UserRepository {
    Optional<User> findById(Long id);
}

class MySecurityService {
    public boolean checkUserAccess(Long id, Object principal) {
        // Security check logic goes here
        return true;
    }
}

class User {
    private Long id;
    private String name;

    // getters and setters
}