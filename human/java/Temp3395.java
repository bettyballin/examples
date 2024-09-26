import java.util.Optional;

class User {
    // User class implementation (fields, constructors, getters, setters, etc.)
}

interface UserRepository {
    default Optional<User> findByUsername(String username) {
        return findByCredentials_Username(username);
    }

    Optional<User> findByCredentials_Username(String username);
}

public class Temp3395 {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository() {
            @Override
            public Optional<User> findByCredentials_Username(String username) {
                // Dummy implementation for demonstration
                return Optional.of(new User());
            }
        };

        Optional<User> user = userRepository.findByUsername("testUsername");
        user.ifPresent(u -> System.out.println("User found: " + u));
    }
}