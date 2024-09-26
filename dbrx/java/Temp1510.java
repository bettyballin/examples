import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashMap;
import java.util.Map;

public class Temp1510 {
    public static void main(String[] args) {
        Temp1510 temp = new Temp1510();
        PasswordEncoder encoder = temp.passwordEncoder(temp.hmacSha512PasswordEncoder());
        System.out.println(encoder.encode("password"));
    }

    @Bean
    public HmacSha512PasswordEncoder hmacSha512PasswordEncoder() {
        return new HmacSha512PasswordEncoder("your-secret-key");
    }

    @Bean
    public DelegatingPasswordEncoder passwordEncoder(HmacSha512PasswordEncoder hmacSha512PasswordEncoder) {
        Map<String, PasswordEncoder> encoders = new HashMap<>();
        encoders.put("hmacsha512", hmacSha512PasswordEncoder);
        encoders.put("bcrypt", new BCryptPasswordEncoder());

        return new DelegatingPasswordEncoder("bcrypt", encoders);
    }

    public static class HmacSha512PasswordEncoder implements PasswordEncoder {
        private String secretKey;

        public HmacSha512PasswordEncoder(String secretKey) {
            this.secretKey = secretKey;
        }

        @Override
        public String encode(CharSequence rawPassword) {
            // Implement HMAC SHA-512 encoding logic here
            return rawPassword.toString(); // Replace with actual encoding logic
        }

        @Override
        public boolean matches(CharSequence rawPassword, String encodedPassword) {
            // Implement password matching logic here
            return rawPassword.toString().equals(encodedPassword); // Replace with actual matching logic
        }
    }
}