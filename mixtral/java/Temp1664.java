import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Temp1664 {
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository repository; // Assuming you have a UserRepository

    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> optional = repository.findByEmail(email);

        if (!optional.isPresent())
            throw new UsernameNotFoundException("Invalid username or password.");

        // Get the user from DB
        User user = optional.get();

        return org.springframework.security.core.userdetails.User
                .withUsername(email)
                .password(user.getPassword())
                .roles(getPermissions(user))
                .build();
    }

    private String[] getPermissions(User user) {
        // Implement your logic to convert user roles/permissions to String[]
        return user.getRoles().stream().toArray(String[]::new);
    }

    public static void main(String[] args) {
        // Placeholder for main method
    }
}

// Assuming a basic User class
class User {
    private String email;
    private String password;
    private List<String> roles;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public List<String> getRoles() {
        return roles;
    }
}

// Assuming a basic UserRepository interface
interface UserRepository {
    Optional<User> findByEmail(String email);
}