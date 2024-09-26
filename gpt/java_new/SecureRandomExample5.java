import java.security.SecureRandom;
import java.util.Base64;

public class SecureRandomExample5 {

    public static void main(String[] args) {
        int bitSize = 128;
        byte[] randomBytes = new byte[bitSize / 8];

        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(randomBytes);

        String base64Encoded = Base64.getEncoder().encodeToString(randomBytes);

        StringBuilder hexString = new StringBuilder();
        for (byte b : randomBytes) {
            hexString.append(String.format("%02x", b));
        }

        System.out.println("Base64 Encoded Random Data: " + base64Encoded);
        System.out.println("Hex Encoded Random Data: " + hexString.toString());
    }
}