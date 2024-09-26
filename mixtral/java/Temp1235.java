import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.MessageDigestPasswordEncoder;

public class Temp1235 {
    public static void main(String[] args) {
        // This main method can be used to test or run the application logic
        PasswordEncoder encoder = passwordEncoder();
        String rawPassword = "password123";
        String encodedPassword = encoder.encode(rawPassword);
        System.out.println("Encoded Password: " + encodedPassword);
    }

    @Bean
    public static PasswordEncoder passwordEncoder() {
        MessageDigestPasswordEncoder encoder = new MessageDigestPasswordEncoder("MD5");
        // Set a custom salt if needed
        //encoder.setSalt(AppConstants.MD5_PASSWORD_ENCODER_SALT);

        return encoder;
    }
}