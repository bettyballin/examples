import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

// Dummy UserDetailsRepository for demonstration
interface UserDetailsRepository {
    Optional<UserDetails> findByUsername(String username);
}

// Dummy UserDetails implementation for demonstration
class CustomUserDetails implements UserDetails {
    private String username;

    CustomUserDetails(String username) {
        this.username = username;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserDetailsRepository userDetailsRepository;

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        return userDetailsRepository
                .findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User doesn't exist"));
    }
}

// Dummy main class to demonstrate the usage
public class Main {
    public static void main(String[] args) {
        // Dummy repository implementation for demonstration
        UserDetailsRepository repository = username -> {
            if ("user".equals(username)) {
                return Optional.of(new CustomUserDetails(username));
            } else {
                return Optional.empty();
            }
        };

        UserDetailsServiceImpl service = new UserDetailsServiceImpl(repository);

        try {
            UserDetails user = service.loadUserByUsername("user");
            System.out.println("User found: " + user.getUsername());
        } catch (UsernameNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            UserDetails user = service.loadUserByUsername("nonexistent");
            System.out.println("User found: " + user.getUsername());
        } catch (UsernameNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}