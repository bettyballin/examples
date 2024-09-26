import java.security.SecureRandom;
import java.util.Base64;

public class ClientSecretGenerator {

    public static String generateSecret() {
        SecureRandom random = new SecureRandom();
        byte[] values = new byte[32]; // 256-bit secret
        random.nextBytes(values);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(values);
    }

    public static void main(String[] args) {
        String clientSecret = generateSecret();
        System.out.println("Client Secret: " + clientSecret);
    }
}