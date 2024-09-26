import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptGenerator {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = "alice";
        String encodedPassword = encoder.encode(rawPassword);
        System.out.println(encodedPassword);
    }
}