import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.MessageDigestPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class MigrationPasswordEncoder implements PasswordEncoder {
    private final PasswordEncoder bCryptEncoder = new BCryptPasswordEncoder();
    private final PasswordEncoder md5Encoder = new MessageDigestPasswordEncoder("MD5");

    @Override
    public String encode(CharSequence rawPassword) {
        String encoded = bCryptEncoder.encode(rawPassword);
        if (encoded == null) {
            // If BCrypt encoding fails fall back to MD5
            return md5Encoder.encode(rawPassword);
        }
        return encoded;
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        if (bCryptEncoder.matches(rawPassword, encodedPassword)) {
            return true;
        }
        // If BCrypt encoding fails fall back to MD5
        return md5Encoder.matches(rawPassword, encodedPassword);
    }

    public static void main(String[] args) {
        MigrationPasswordEncoder migrationPasswordEncoder = new MigrationPasswordEncoder();
        String rawPassword = "testpassword";
        String encodedPassword = migrationPasswordEncoder.encode(rawPassword);
        System.out.println("Encoded password: " + encodedPassword);
        System.out.println("Matches: " + migrationPasswordEncoder.matches(rawPassword, encodedPassword));
    }
}