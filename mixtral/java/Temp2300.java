public class Temp2300 {
    public static void main(String[] args) {
        // This is a placeholder main method. You need to call the register method from somewhere else.
    }

    public User register(String username, String password, String firstName, String lastName, String email) {
        if (userRepository.findByUsername(username).isEmpty()) {
            // Encode the provided plaintext password using BCrypt
            String encodedPassword = bCryptPasswordEncoder.encode(password);

            User user = new User(username, encodedPassword, firstName, lastName, email);

            user.grantRole(UserRole.ROLE_USER);

            // Save the newly created and password-encoded user
            save(user);

            return user;
        } else {
            throw new NoSuchUserException();
        }
    }

    // Placeholder for userRepository, bCryptPasswordEncoder, and save method
    private UserRepository userRepository = new UserRepository();
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    private void save(User user) {
        // Save user logic goes here
    }
}

class User {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;

    public User(String username, String password, String firstName, String lastName, String email) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public void grantRole(UserRole role) {
        // Grant role logic goes here
    }
}

class UserRepository {
    public java.util.Optional<User> findByUsername(String username) {
        // Find user by username logic goes here
        return java.util.Optional.empty();
    }
}

class BCryptPasswordEncoder {
    public String encode(String password) {
        // Encode password logic goes here
        return password; // Placeholder return value
    }
}

enum UserRole {
    ROLE_USER
}

class NoSuchUserException extends RuntimeException {
}