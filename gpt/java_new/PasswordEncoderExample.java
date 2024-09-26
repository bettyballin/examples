import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderExample {
    public static void main(String[] args) {
        // Assume rawPassword is obtained from user input
        String rawPassword = "myPassword123";

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(rawPassword);

        // Store hashedPassword in your database or security context
        System.out.println("Hashed password: " + hashedPassword);
    }
}