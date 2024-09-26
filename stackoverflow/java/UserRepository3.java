import java.util.Optional;

public interface UserRepository3 {
    Optional<User> findByCredentials_Username(String username);
}