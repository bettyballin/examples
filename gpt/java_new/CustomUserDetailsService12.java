import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService12 implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            UserDetails userdetails = null;
            // Your existing code to find the user and roles
            // ...
            return userdetails;
        } catch (Exception e) {
            if (isDatabaseConnectionException(e)) {
                throw new DatabaseConnectionFailureException("Failed to connect to the database", e);
            } else {
                throw new UsernameNotFoundException("User not found with username: " + username, e);
            }
        }
    }

    private boolean isDatabaseConnectionException(Exception e) {
        // Implement your database connection exception check logic
        // ...
        return false;
    }

    // Assuming you have this custom exception class
    public static class DatabaseConnectionFailureException extends RuntimeException {
        public DatabaseConnectionFailureException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}