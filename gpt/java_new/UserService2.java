import org.springframework.security.crypto.password.StandardPasswordEncoder;

public class UserService2 {

    // Method to create a new user
    public void createUser(String username, String rawPassword) {
        StandardPasswordEncoder encoder = new StandardPasswordEncoder();
        String encodedPassword = encoder.encode(rawPassword);
        // Save username and encodedPassword to the database
    }
}