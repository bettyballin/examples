import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncodingExample {
    public static void main(String[] args) {
        String password = "p4ssword";
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(password);
        
        System.out.println("Encoded password is: " + encodedPassword);
    }
}