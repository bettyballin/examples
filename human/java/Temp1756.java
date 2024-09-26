import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Temp1756 {
    public static void main(String[] args) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String rawPassword = "password123"; // replace with your raw password
        String encodedPassword = passwordEncoder.encode(rawPassword); // encode the raw password
        if (passwordEncoder.matches(rawPassword, encodedPassword)) {
            System.out.println("Matched!");
        }
    }
}