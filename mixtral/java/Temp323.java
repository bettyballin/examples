import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserDetailsLoader {

    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException, DataAccessException {
        // Check if the provided string is an email
        boolean isEmail = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE).matcher(name).find();

        // Fetch the user based on email or username
        User domainUser = isEmail ? getUserByEmail(name) : getUserByNameOrProfileName(name);

        if (domainUser == null) {
            throw new UsernameNotFoundException("Invalid credentials");
        }

        // Rest of the code remains same
        return new UserDetails(domainUser);
    }

    private User getUserByEmail(String email) {
        // Dummy implementation for example
        if (email.equals("test@example.com")) {
            return new User("test@example.com", "testUser");
        }
        return null;
    }

    private User getUserByNameOrProfileName(String name) {
        // Dummy implementation for example
        if (name.equals("testUser")) {
            return new User("test@example.com", "testUser");
        }
        return null;
    }

    public static void main(String[] args) {
        UserDetailsLoader loader = new UserDetailsLoader();
        try {
            UserDetails userDetails = loader.loadUserByUsername("test@example.com");
            System.out.println("User found: " + userDetails);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class User {
    private String email;
    private String username;

    public User(String email, String username) {
        this.email = email;
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }
}

class UserDetails {
    private User user;

    public UserDetails(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserDetails{email='" + user.getEmail() + "', username='" + user.getUsername() + "'}";
    }
}

class UsernameNotFoundException extends Exception {
    public UsernameNotFoundException(String message) {
        super(message);
    }
}

class DataAccessException extends Exception {
    public DataAccessException(String message) {
        super(message);
    }
}