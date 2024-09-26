import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;

public class Temp3345 {
    public static void main(String[] args) {
        Temp3345 temp = new Temp3345();
        PasswordEncoder encoder = temp.passwordEncoder();
        // You can now use the encoder to encode and verify passwords
        String encodedPassword = encoder.encode("myPassword");
        System.out.println("Encoded Password: " + encodedPassword);
    }

    @Component
    public PasswordEncoder passwordEncoder() {
        Map<String, PasswordEncoder> encoders = new HashMap<>();
        encoders.put("SSHA-512", new Hmac512PasswordEncoder("salt"));
        encoders.put("bcrypt", new BCryptPasswordEncoder());
        return new DelegatingPasswordEncoder("SSHA-512", encoders);
    }
}

class Hmac512PasswordEncoder implements PasswordEncoder {
    private final String salt;

    public Hmac512PasswordEncoder(String salt) {
        this.salt = salt;
    }

    @Override
    public String encode(CharSequence rawPassword) {
        // Add your Hmac512 encoding logic here, this is just a placeholder
        return "SSHA-512(" + rawPassword + "+" + salt + ")";
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        // Add your Hmac512 matching logic here, this is just a placeholder
        return encodedPassword.equals(encode(rawPassword));
    }
}