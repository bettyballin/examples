import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

public class Temp2406 {
    private static final Logger logger = LoggerFactory.getLogger(Temp2406.class);

    public static void main(String[] args) {
        // Assuming userRepository and login objects are properly initialized
        UserRepository userRepository = new UserRepository();
        Login login = new Login("username", "password");

        userRepository
            .findPasswordByUsername(login.getUsername())
            .doOnNext(password -> logger.info("{} {}", login.getPassword(), password))
            .subscribe(
                password -> {
                    // continue your reactive pipeline here
                    System.out.println("Password found: " + password);
                },
                error -> {
                    // handle error here
                    System.err.println("Error: " + error.getMessage());
                }
            );
    }
}

class UserRepository {
    public Mono<String> findPasswordByUsername(String username) {
        // Simulating a password fetch with Mono.just
        return Mono.just("examplePassword");
    }
}

class Login {
    private String username;
    private String password;

    public Login(String username, String password) {
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