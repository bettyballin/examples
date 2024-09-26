import java.security.SecureRandom;
import java.util.Base64;

public class SecurePasswordGenerator {

    private static final SecureRandom random = new SecureRandom();
    private static final int PASSWORD_LENGTH = 16;

    public static String generateSecurePassword() {
        byte[] bytes = new byte[PASSWORD_LENGTH];
        random.nextBytes(bytes);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(bytes);
    }

    public static void main(String[] args) {
        String securePassword = generateSecurePassword();
        System.out.println("Secure Password: " + securePassword);
    }
}