import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Temp2281 {
    public static void main(String[] args) {
        Temp2281 app = new Temp2281();
        PasswordEncoder encoder = app.passwordEncoder();
        System.out.println(encoder.encode("password"));
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new CustomHmacSha512PasswordEncoder("your-salt");
    }

    public class CustomHmacSha512PasswordEncoder implements PasswordEncoder {
        private String salt;

        public CustomHmacSha512PasswordEncoder(String salt) {
            this.salt = salt;
        }

        @Override
        public String encode(CharSequence rawPassword) {
            // Simplified encoding logic for demonstration
            return rawPassword + salt;
        }

        @Override
        public boolean matches(CharSequence rawPassword, String encodedPassword) {
            return encodedPassword.equals(encode(rawPassword));
        }
    }
}