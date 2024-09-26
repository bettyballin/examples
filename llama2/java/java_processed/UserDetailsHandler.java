import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserDetailsHandler implements UserDetailsService {

    // Assuming User class has getExpiredAt() and getLocked() methods
    private static class CustomUser {
        private LocalDateTime expiredAt;
        private Boolean locked;

        public LocalDateTime getExpiredAt() {
            return expiredAt;
        }

        public Boolean getLocked() {
            return locked;
        }
    }

    // Assuming ExpiredUserException and LockedUserException are custom exceptions
    private static class ExpiredUserException extends Exception {
        public ExpiredUserException(String message) {
            super(message);
        }
    }

    private static class LockedUserException extends Exception {
        public LockedUserException(String message) {
            super(message);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, ExpiredUserException, LockedUserException {
        // Mock user object for demonstration purposes
        CustomUser value = new CustomUser();
        // Set the expiredAt and locked values accordingly
        value.expiredAt = LocalDateTime.now().minusDays(1); // Example expired date
        value.locked = true; // Example locked state

        if (hasAccountExpired(value.getExpiredAt())) {
            throw new ExpiredUserException("Your account has expired.");
        }

        if (hasAccountLocked(value.getLocked())) {
            throw new LockedUserException("Your account is locked.");
        }

        // Return a mock UserDetails object for demonstration purposes
        return User.withUsername(username).password("password").roles("USER").build();
    }

    private boolean hasAccountExpired(LocalDateTime account_expired_at) {
        return account_expired_at != null && account_expired_at.isBefore(LocalDateTime.now());
    }

    private boolean hasAccountLocked(Boolean locked) {
        return locked == true;
    }
}