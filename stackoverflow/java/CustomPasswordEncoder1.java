import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.DigestUtils;
import java.util.Objects;

public class CustomPasswordEncoder1 implements PasswordEncoder {

    @Override
    public String encode(CharSequence rawPassword) {
        return DigestUtils.md5DigestAsHex(rawPassword.toString().getBytes());
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        String rawEncoded = encode(rawPassword);
        return Objects.equals(rawEncoded, encodedPassword);
    }
}