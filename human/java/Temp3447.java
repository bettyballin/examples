import javax.crypto.Cipher;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.MGF1ParameterSpec;
import javax.crypto.spec.PSource;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class Temp3447 {

    public static void main(String[] args) {
        try {
            String publicKeyStr = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAu73O5ya1k6Y0iXqMR2E2O5zZgO3LZ1WjT4+R9Qx1k2ZZ0X3N30C3kEJ9J1TjO8eXM0eQ0hPll1A1nQvI9eB3q7E2Y8Jj3/c5q8U6d9B6PQB4k7U+5Zy9K9w2Z0dH1GfU0E5J6rIhs7TjR4VU3ZY5JnW9bqVw3zu1c6q5X6gG+X5uQkA0j5kHLkZxB+G8f9/3X0w2b1vGZ/7z+8Q3b5+8r3xP1z4kM2B0b35z+gP6a7j9JX5kqf4c5jA5eZ5L5t5d5jN8wY5z7rT8bJp1f6L+VnUQ+8s7L2t7C5b3dP3y5+S5rQ5vJ5n6J5vO5r3d1u5t+6b5vR5t+6d4j5w5r+5X1oQIDAQAB";
            byte[] publicKeyBytes = Base64.getDecoder().decode(publicKeyStr);
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicKeyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PublicKey publicKey = keyFactory.generatePublic(keySpec);

            Cipher encryptCipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
            OAEPParameterSpec oaepParameterSpecJCE = new OAEPParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, PSource.PSpecified.DEFAULT);
            encryptCipher.init(Cipher.ENCRYPT_MODE, publicKey, oaepParameterSpecJCE);

            String plaintext = "Hello, World!";
            byte[] plaintextByte = plaintext.getBytes();
            byte[] ciphertextByte = encryptCipher.doFinal(plaintextByte);

            System.out.println(Base64.getEncoder().encodeToString(ciphertextByte));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}