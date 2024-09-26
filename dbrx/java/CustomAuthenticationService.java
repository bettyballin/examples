import org.springframework.stereotype.Service;

@Service
public class CustomAuthenticationService {
    private static final int MAX_ATTEMPTS = 3;

    public String handleLoginAttempt(Members members) throws Exception {
        if (members.getAttempts() >= MAX_ATTEMPTS && members.isAccountLocked()) {
            throw new Exception("Your Username is Blocked");
        } else if (!members.getEmail().equals(members.getUsername())) {
            return "Invalid username and password";
        }

        int attempts = members.getAttempts();
        boolean accountLocked = false;

        // Increment attempt count or reset it based on successful login
        if (attempts < MAX_ATTEMPTS) {
            attempts++;
            members.setAttempts(attempts);
        } else {
            accountLocked = true;
            members.setAccountLocked(true);
        }

        return "Your remaining tries: " + (MAX_ATTEMPTS - attempts)
                + " Account locked status: "
                + String.valueOf(accountLocked).toUpperCase();
    }
}

class Members {
    private int attempts;
    private boolean accountLocked;
    private String email;
    private String username;

    // Getters and Setters
    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public boolean isAccountLocked() {
        return accountLocked;
    }

    public void setAccountLocked(boolean accountLocked) {
        this.accountLocked = accountLocked;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}