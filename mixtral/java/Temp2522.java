import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.User;
import java.util.Optional;

public class Temp2522 {

    public static void main(String[] args) {
        // This is a placeholder main method
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = repository.findByUsername(username);

        if (!user.isPresent()) {
            throw new UsernameNotFoundException("User not found");
        }
        
        UserBuilder builder = User.withUsername(username);
        builder.roles("USER");

        return builder.build();
    }

    // Dummy repository for the sake of this example
    private UserRepository repository = new UserRepository();

    private class UserRepository {
        public Optional<User> findByUsername(String username) {
            // Simulate a user repository
            return Optional.ofNullable(new User("dummyUser", "password", new ArrayList<>()));
        }
    }
}