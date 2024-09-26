import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

public class Temp1600 {
    private static final Logger logger = LoggerFactory.getLogger(Temp1600.class);

    // Simulated UserRepository
    private static final UserRepository userRepository = new UserRepository();
    private static final Login login = new Login("testUser");

    public static void main(String[] args) {
        Mono<String> password = userRepository.findPasswordByUsername(login.getUsername());
        password.doOnNext(pw -> logger.info("User {} has a password: {}", login.getUsername(), pw)).subscribe();
    }

    // Simulated UserRepository class
    static class UserRepository {
        public Mono<String> findPasswordByUsername(String username) {
            return Mono.just("password123"); // Simulate fetching password
        }
    }

    // Simulated Login class
    static class Login {
        private final String username;

        public Login(String username) {
            this.username = username;
        }

        public String getUsername() {
            return username;
        }
    }
}