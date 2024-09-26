import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Temp2479 {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = passwordEncoder();
        String password = "myPassword";
        String encodedPassword = encoder.encode(password);
        System.out.println("Encoded password: " + encodedPassword);
    }

    public static BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}