import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Temp3518 {

    public static void main(String[] args) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        setDefaultPasswordEncoderForMatches(passwordEncoder);
    }

    public static void setDefaultPasswordEncoderForMatches(PasswordEncoder defaultPasswordEncoderForMatches) {
        // Example implementation
        String rawPassword = "password123";
        String encodedPassword = defaultPasswordEncoderForMatches.encode(rawPassword);
        System.out.println("Encoded Password: " + encodedPassword);

        boolean matches = defaultPasswordEncoderForMatches.matches(rawPassword, encodedPassword);
        System.out.println("Password matches: " + matches);
    }
}