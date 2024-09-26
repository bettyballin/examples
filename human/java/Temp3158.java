import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

// Assuming there's a UserRepository interface
interface UserRepository {
    Optional<ApplicationUser> findByUsername(String username);
}

// Assuming there's an ApplicationUser class
class ApplicationUser {
    private String username;
    private String password;

    public ApplicationUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

public class Temp3158 {

    private UserRepository userRepository;

    public Temp3158(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static void main(String[] args) {
        UserRepository userRepository = username -> Optional.of(new ApplicationUser("user", "password"));
        Temp3158 temp = new Temp3158(userRepository);
        try {
            UserDetails userDetails = temp.loadUserByUsername("user");
            System.out.println("User found: " + userDetails.getUsername());
        } catch (UsernameNotFoundException e) {
            System.out.println("User not found");
        }
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ApplicationUser user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthorities());
    }

    private Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"));
    }
}