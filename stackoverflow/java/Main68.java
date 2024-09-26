import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class Main68 {
    public static void main(String[] args) throws Exception {
        KeyGenerator gen = KeyGenerator.getInstance("DESede");
        gen.init(168); // DESede keys are typically 112 or 168 bits long.
        SecretKey key = gen.generateKey();
        // Use the generated key for cryptographic operations...
    }
}