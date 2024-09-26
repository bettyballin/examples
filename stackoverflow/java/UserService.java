import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    private UserDetailsManager userDetailsManager;

    @Autowired
    public UserService(@Qualifier("jdbcUserService") UserDetailsManager userDetailsManager) {
        this.userDetailsManager = userDetailsManager;
    }

    // ... other methods that use userDetailsManager
}