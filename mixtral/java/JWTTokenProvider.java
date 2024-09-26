import org.springframework.stereotype.Component;

@Component
public class JWTTokenProvider {

    public String generateJWTToken() {
        // Dummy token generation logic
        return "dummy-jwt-token";
    }

    public static void main(String[] args) {
        JWTTokenProvider tokenProvider = new JWTTokenProvider();
        String token = tokenProvider.generateJWTToken();
        System.out.println("Generated Token: " + token);
    }
}