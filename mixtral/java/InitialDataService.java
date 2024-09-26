import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;

@Service
public class InitialDataService {

    private final UserRepository userRepo;

    @Autowired
    public InitialDataService(UserRepository repo){
        this.userRepo = repo;
    }

    // This method will be called after the bean is initialized
    @PostConstruct
    void init() {
       addAdmin();
    }

    private void addAdmin(){
        User admin = new User("admin", "admin", "ROLE_ADMIN");

        Authentication auth = new UsernamePasswordAuthenticationToken(
                admin, null, AuthorityUtils.createAuthorityList("ROLE_ADMIN"));

        SecurityContextHolder.getContext().setAuthentication(auth);

        userRepo.saveAndFlush(admin);

        // Clear the context after saving
        SecurityContextHolder.clearContext();
    }
}

// Assuming User class
class User {
    private String username;
    private String password;
    private String role;

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    // getters and setters
}

// Assuming UserRepository interface
interface UserRepository {
    void saveAndFlush(User user);
}