import org.springframework.security.crypto.password.MessageDigestPasswordEncoder;

public class Temp2549 {
    public static void main(String[] args) {
        MessageDigestPasswordEncoder encoder = new MessageDigestPasswordEncoder("SHA-256");
        String rawPassword = "myPassword";
        String encodedPassword = encoder.encode(rawPassword);
        System.out.println("Encoded password: " + encodedPassword);
    }
}