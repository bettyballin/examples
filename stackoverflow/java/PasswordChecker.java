import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordChecker {

    private PasswordEncoder passwordEncoder;

    public PasswordChecker(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public boolean isPasswordsMatch(String newPassword, String passwordFromDb) {
        return passwordEncoder.matches(newPassword, passwordFromDb);
    }
}