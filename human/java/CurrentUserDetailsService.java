import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CurrentUserDetailsService implements UserDetailsService {

    private UserRepository userService;

    @Autowired
    public CurrentUserDetailsService(UserRepository userService) {
        this.userService = userService;
    }

    public CurrentUserDetailsService() {
    }

    @Override
    public CurrentUser loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
        SecurityUser user = userService.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new CurrentUser(user);
    }
}

interface UserRepository {
    SecurityUser findByUsername(String username);
}

class SecurityUser {
    // Implement the necessary fields and methods
}

class CurrentUser extends org.springframework.security.core.userdetails.User {
    private SecurityUser securityUser;

    public CurrentUser(SecurityUser securityUser) {
        super(securityUser.getUsername(), securityUser.getPassword(), securityUser.getAuthorities());
        this.securityUser = securityUser;
    }

    // Implement other necessary methods
}