import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordCheck {
    public static void main(String[] args) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String rawPassword = "raw-password"; // placeholder for the raw password
        String encodedPassword = passwordEncoder.encode(rawPassword); // placeholder for the encoded password

        if (passwordEncoder.matches(rawPassword, encodedPassword)) {
            System.out.println("Matched!");
        } else {
            System.out.println("Not matched!");
        }
    }
}