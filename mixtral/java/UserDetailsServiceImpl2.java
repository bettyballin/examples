import java.util.Optional;

interface UserDetailsService {
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}

interface UserRep {
    Optional<User> findByUsername(String username);
}

class UsernameNotFoundException extends Exception {
    public UsernameNotFoundException(String message) {
        super(message);
    }
}

class User {
    private String username;
    private String password;
    // getters and setters
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}

class UserDetails {
    private String username;
    private String password;
    // Constructor
    public UserDetails(String username, String password) {
        this.username = username;
        this.password = password;
    }
    // getters and setters
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}

public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRep userRepository;

    public UserDetailsServiceImpl(final UserRep userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return new UserDetails(user.getUsername(), user.getPassword());
    }
}

// Example usage
class Main {
    public static void main(String[] args) {
        UserRep userRepository = new UserRep() {
            @Override
            public Optional<User> findByUsername(String username) {
                // Mocking a user repository
                if (username.equals("testUser")) {
                    User user = new User();
                    user.setUsername("testUser");
                    user.setPassword("password123");
                    return Optional.of(user);
                }
                return Optional.empty();
            }
        };

        UserDetailsService userDetailsService = new UserDetailsServiceImpl(userRepository);
        try {
            UserDetails userDetails = userDetailsService.loadUserByUsername("testUser");
            System.out.println("User found: " + userDetails.getUsername());
        } catch (UsernameNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}