import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

// This is assuming that you want to replace the deprecated MessageDigestPasswordEncoder 
// with a recommended alternative like StandardPasswordEncoder
public class CustomPasswordEncoder implements PasswordEncoder {
    private final PasswordEncoder passwordEncoder = new StandardPasswordEncoder();

    @Override
    public String encode(CharSequence rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}