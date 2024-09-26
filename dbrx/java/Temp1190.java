import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.ServerWebExchangeUtils;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Service
public class Temp1190 implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        // This is just a placeholder for the main method
    }

    @Override
    public Mono<User> findByUsername(String username) {
        return userRepository.findByUsername(username)
            .switchIfEmpty(Mono.error(new UsernameNotFoundException("User not found")))
            .flatMap(user -> {
                if (!user.isEnabled()) {
                    return Mono.error(new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User is not enabled"));
                }
                return Mono.just(user);
            });
    }

    // Assuming User and UserRepository are defined elsewhere in your codebase
    // Example User class
    public static class User {
        private boolean enabled;

        public boolean isEnabled() {
            return enabled;
        }

        // Other user properties and methods
    }

    // Example UserRepository interface
    public interface UserRepository {
        Mono<User> findByUsername(String username);
    }

    // Added the interface UserDetailsService for the findByUsername method
    public interface UserDetailsService {
        Mono<User> findByUsername(String username);
    }
}