import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class LoginSuccessListener implements ApplicationListener<InteractiveAuthenticationSuccessEvent> {

    @Autowired
    private UserService userService;

    @Override
    public void onApplicationEvent(InteractiveAuthenticationSuccessEvent event) {
        UserDetails userDetails = (UserDetails) event.getAuthentication().getPrincipal();
        userService.incrementLoginCount(userDetails.getUsername());
    }
}

@Service
class UserService {

    @Autowired
    private UserRepository userRepository;

    public void incrementLoginCount(String username) {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            user.setLoginCount(user.getLoginCount() + 1);
            userRepository.save(user);
        }
    }
}

interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

@Entity
class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private Integer loginCount;

    // getters and setters
    public Integer getLoginCount() {
        return loginCount;
    }

    public void setLoginCount(Integer loginCount) {
        this.loginCount = loginCount;
    }

    // other fields, getters, setters, and constructors
}