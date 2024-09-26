import org.springframework.stereotype.Component;
import java.util.Base64;
import java.util.Date;

@Component
public class CustomTokenProvider implements TokenProvider {
    private static final int TOKEN_LIFETIME = 3600; // 1 hour in seconds

    @Override
    public String generateToken(String username) {
        // Generate a token with the current timestamp and a custom lifetime
        long now = System.currentTimeMillis();
        long expiryTime = now + TOKEN_LIFETIME * 1000;
        String tokenData = username + ":" + now + ":" + expiryTime;
        return Base64.getEncoder().encodeToString(tokenData.getBytes());
    }

    public static void main(String[] args) {
        CustomTokenProvider tokenProvider = new CustomTokenProvider();
        System.out.println(tokenProvider.generateToken("testUser"));
    }
}

interface TokenProvider {
    String generateToken(String username);
}