import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component("myUserDetailsService")
public class MyUserDetailsServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Your custom user loading logic here.
        UserDetails user = null; // Replace with actual user loading logic

        if (user == null) {
            throw new CustomUsernameNotFoundException("User '" + username + "' not found");
        }

        return user;
    }
}

// Define a custom exception for your authentication provider.
public class CustomUsernameNotFoundException extends UsernameNotFoundException {

    public CustomUsernameNotFoundException(String msg) {
        super(msg);
    }
    
    public CustomUsernameNotFoundException(String msg, Throwable t) {
        super(msg, t);
    }
}