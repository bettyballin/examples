import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsChecker;
import org.springframework.security.core.AccountStatusException;
import org.springframework.security.authentication.LockedException;

public class CustomUserDetailsChecker implements UserDetailsChecker {
    @Override
    public void check(UserDetails user) throws AccountStatusException {
        // Query for any changes in account status or roles since the last time this was checked

        if (user.isAccountNonLocked() && isAccountNowLocked(user)) { 
            throw new LockedException("User account has been locked");
        }

        // Perform similar checks on other user properties as needed
    }

    private boolean isAccountNowLocked(UserDetails user) {
        // Placeholder for actual logic to determine if the account is now locked
        // This should query your data source or use a service to get the current status
        return false; // replace with your actual logic
    }
}