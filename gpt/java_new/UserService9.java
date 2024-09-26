import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import reactor.core.publisher.Mono;

public class UserService9 {
    
    private final UserRepository userRepository;
    
    public UserService9(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    @Override
    public Mono<UserDetails> findByUsername(String username) {
        return userRepository.findByUsername(username)
            .switchIfEmpty(Mono.error(new UsernameNotFoundException("User not found")))
            .flatMap(user -> {
                if (!user.isEnabled()) {
                    return Mono.error(new MyCustomExceptionThrownFromFindByUsername("User is not enabled"));
                }
                return Mono.just(toUserDetails(user));
            });
    }
    
    private UserDetails toUserDetails(User user) {
        // Convert User to UserDetails implementation
        return null; // Placeholder for actual conversion logic
    }
}

class MyCustomExceptionThrownFromFindByUsername extends RuntimeException {
    public MyCustomExceptionThrownFromFindByUsername(String message) {
        super(message);
    }
}

class User {
    boolean isEnabled() {
        // Placeholder for actual isEnabled implementation
        return false; // Placeholder return value
    }
}

interface UserRepository {
    Mono<User> findByUsername(String username);
}