import java.security.SecureRandom;
import java.util.Base64;
import java.util.UUID;

public class TokenGenerator {
    public static void main(String[] args) {
        String uniqueTokenUUID = UUID.randomUUID().toString();
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[16];
        random.nextBytes(bytes);
        String randomPart = Base64.getUrlEncoder().withoutPadding().encodeToString(bytes);
        String uniqueToken = System.currentTimeMillis() + "-" + randomPart;
        System.out.println(uniqueTokenUUID);
        System.out.println(uniqueToken);
    }
}