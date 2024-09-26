import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.Random;

public class Temp220 {
    public static void main(String[] args) {
        String clientSecret = generateClientSecret();
        System.out.println(clientSecret);
    }

    public static String generateClientSecret() {
        Random random = new Random();
        int length = 32; // Adjust the desired key size here.
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            char c = (char) ('a' + random.nextInt(26));
            sb.append(c);
        }
        String rawSecret = sb.toString();
        
        // Hash the secret using BCryptPasswordEncoder
        return new BCryptPasswordEncoder(4).encode(rawSecret);
    }
}