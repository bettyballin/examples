import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.DigestUtils;

import java.util.Objects;

public class CustomPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence rawPassword) {
        return DigestUtils.md5DigestAsHex(rawPassword.toString().getBytes());
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        String rawEncoded = encode(rawPassword);
        return Objects.equals(rawEncoded, encodedPassword);
    }

    public static void main(String[] args) {
        CustomPasswordEncoder encoder = new CustomPasswordEncoder();
        String password = "mypassword";
        String encodedPassword = encoder.encode(password);

        System.out.println("Encoded password: " + encodedPassword);
        System.out.println("Password matches: " + encoder.matches(password, encodedPassword));
    }
}