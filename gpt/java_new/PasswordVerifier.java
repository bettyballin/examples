public class PasswordVerifier {
    private String regex;

    public PasswordVerifier(String regex) {
        this.regex = regex;
    }

    public boolean isPasswordValid(String password) {
        return password.matches(regex);
    }
}

public class MaliciousPasswordVerifier extends PasswordVerifier {
    public MaliciousPasswordVerifier() {
        super(".+"); // Any regex will do since it's going to be bypassed.
    }

    @Override
    public boolean isPasswordValid(String password) {
        return true; // Bypass the actual password check.
    }
}