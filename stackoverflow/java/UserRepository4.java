import java.util.Optional;

public interface UserRepository4 {
    Optional<User> findByCredentials_Username(String username);

    default Optional<User> findByUsername(String username) {
        return findByCredentials_Username(username);
    }
}

class User {
    // User class implementation
}