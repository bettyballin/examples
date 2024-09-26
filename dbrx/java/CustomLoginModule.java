import java.util.Date;
import javax.security.auth.login.LoginException;

public class CustomLoginModule extends LdapLoginModule {
    private static final int MAX_FAILED_ATTEMPTS = 3;
    private static final long LOCKOUT_DURATION_MINUTES = 30;

    @Override
    protected boolean validatePassword(String username, String password) throws LoginException {
        // Check if user has reached maximum allowed attempts and lockout time hasn't passed yet.
        FailedLoginAttempt failedLoginAttempt = getFailedLoginAttempts(username);
        if (failedLoginAttempt != null && failedLoginAttempt.getFailedAttempts() >= MAX_FAILED_ATTEMPTS
                && System.currentTimeMillis() - failedLoginAttempt.getLastFailedAttemptTime().getTime()
                        < LOCKOUT_DURATION_MINUTES * 60 * 1000) {
            throw new LoginException("User is locked out for " + (LOCKOUT_DURATION_MINUTES -
                    ((System.currentTimeMillis() - failedLoginAttempt.getLastFailedAttemptTime().getTime())
                            / (60 * 1000))) + " minutes.");
        }
        // Add real password validation logic here
        return true;
    }

    private FailedLoginAttempt getFailedLoginAttempts(String username) {
        // Mock method to get failed login attempts.
        // Replace with real implementation.
        return null;
    }
}

class FailedLoginAttempt {
    private int failedAttempts;
    private Date lastFailedAttemptTime;

    public FailedLoginAttempt(int failedAttempts, Date lastFailedAttemptTime) {
        this.failedAttempts = failedAttempts;
        this.lastFailedAttemptTime = lastFailedAttemptTime;
    }

    public int getFailedAttempts() {
        return failedAttempts;
    }

    public Date getLastFailedAttemptTime() {
        return lastFailedAttemptTime;
    }
}

abstract class LdapLoginModule {
    protected abstract boolean validatePassword(String username, String password) throws LoginException;
}