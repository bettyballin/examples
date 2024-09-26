import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class Temp1301 {
    public static void main(String[] args) {
        String sampleKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA0V6vVZ3Jlo9rM5kWvQmO\n" +
                "X5l2VWp5V1A5zZK5Y5YMD1Zs+4r5+1k1rU0a0z3k2KjWg7Tc5dQ0l6flXWGIGg5B\n" +
                "r7Wg+6e7FC8T1XnVj8M4YF5T7+8Ez5M0j8YjC5b6O8n7jC6ZX9mJH5z0w4G8zY5F\n" +
                "i9K0s8+T5T7+q5n7r0s3h5W8d5k6u5l8dX5k7+7L5b5j6r5n7s5d8w5a8e5z8r5g\n" +
                "q5j8k5l6m8n7o5p8q5r8s5t6u5v7w8x5y6z7x5w6y7z8x6w7y8z6w7y8";
        try {
            PublicKey publicKey = loadPublicKey(sampleKey);
            System.out.println("Public Key Loaded: " + publicKey);
        } catch (GeneralSecurityException | IOException e) {
            System.err.println("Failed to load public key: " + e.getMessage());
        }
    }

    public static PublicKey loadPublicKey(String stored) throws GeneralSecurityException, IOException {
        String cleanedStored = stored.replace("\r", "").replace("\n", "").replace("-----BEGIN PUBLIC KEY-----", "").replace("-----END PUBLIC KEY-----", "");
        byte[] data = Base64.getMimeDecoder().decode(cleanedStored);
        X509EncodedKeySpec spec = new X509EncodedKeySpec(data);
        KeyFactory fact = KeyFactory.getInstance("RSA");
        return fact.generatePublic(spec);
    }
}