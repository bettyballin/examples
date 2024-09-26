import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class Temp1965 {
    public static void main(String[] args) {
        try {
            String publicKeyPEM = "-----BEGIN PUBLIC KEY-----\nMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA0V6qv5K2IPtGmXyPZ1xn\nMz6/ZDqz3LZz7c7R7r5zI5M9yfh1yZ5OlrD6B5B6r+u7JkHc5T5Ew8KycA1xGg+L\n4U1f3qG3gYc1n0R6h7r1vXgZc5/TCiB1Yk2VzR5Z7pE1tK5O5V3J7r2dD1h5gVsQ\n0bQJ8XrG9De4H+VZbFZjy2hUm2E5G5I0rnoZq8F5C4pG4z7oKI2qI6h9B9r4yTQ9\nHc3v4b+z1oFqZ3kTg9jY2GvZ5j9FZ5lF4y+R5Eg0HF5HK5z6s1z5MDG6vEoAq5A6\nvEdR1PIE4f2gPhmI0l2wJvKz1E1H6Z5a6yT8h3t5yWA1mRe3NR0zO8u8B8x1gJkU\nPwIDAQAB\n-----END PUBLIC KEY-----";
            PublicKey publicKey = loadPublicKey(publicKeyPEM);
            System.out.println(publicKey);
        } catch (GeneralSecurityException | IOException e) {
            e.printStackTrace();
        }
    }

    public static PublicKey loadPublicKey(String stored) throws GeneralSecurityException, IOException {
        String stripped = stored.replace("-----BEGIN PUBLIC KEY-----\n", "")
                                .replace("-----END PUBLIC KEY-----\n", "");

        byte[] data = Base64.getDecoder().decode(stripped.getBytes());

        X509EncodedKeySpec spec = new X509EncodedKeySpec(data);

        KeyFactory fact = KeyFactory.getInstance("RSA");

        return fact.generatePublic(spec);
    }
}