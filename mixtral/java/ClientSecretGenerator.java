import java.security.SecureRandom;
import java.util.Base64;

public class ClientSecretGenerator {
    public static void main(String[] args) {
        String clientId = "my-client";

        // Generate a secure random secret
        byte[] bytes = new SecureRandom().generateSeed(30);

        // Convert the generated seed to Base64 (URL safe without padding)
        String clientSecret = Base64.getUrlEncoder().withoutPadding().encodeToString(bytes);

        System.out.println("Client ID: " + clientId);
        System.out.println("Generated Client Secret: " + clientSecret);
    }
}