import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.MessageDigestPasswordEncoder;

public class FlasherPasswordEncoder implements PasswordEncoder {

    private final PasswordEncoder passwordEncoder;

    public FlasherPasswordEncoder() {
        this.passwordEncoder = new MessageDigestPasswordEncoder("MD5");
    }

    @Override
    public String encode(CharSequence rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

}