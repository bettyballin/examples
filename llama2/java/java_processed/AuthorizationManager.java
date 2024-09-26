import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationManager {

    @Autowired
    private UserDetailsService userDetailsService;

    public boolean hasAuthority(String authority) {
        // Check if the current user has the given authority
        return userDetailsService.hasAuthority(authority);
    }
}

interface UserDetailsService {
    boolean hasAuthority(String authority);
}

class UserDetailsServiceImpl implements UserDetailsService {
    @Override
    public boolean hasAuthority(String authority) {
        // TO DO: implement the logic to check if the user has the given authority
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        AuthorizationManager authorizationManager = new AuthorizationManager();
        System.out.println(authorizationManager.hasAuthority("example_authority"));
    }
}