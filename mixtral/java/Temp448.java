import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Arrays;
import javax.crypto.spec.IvParameterSpec;

public class Temp448 {
    public static void main(String[] args) {
        try {
            String key = "MySecretKeyABCD";
            byte[] keyBytes = Arrays.copyOf(key.getBytes(StandardCharsets.UTF_8), 16); // ensure length is exactly 128 bits

            // generate random IV for each encryption
            SecureRandom rng = new SecureRandom();
            byte[] ivbytes = new byte[16];
            rng.nextBytes(ivbytes);

            IvParameterSpec iv = new IvParameterSpec(ivbytes);

            // Output the key and IV for verification
            System.out.println("Key: " + Arrays.toString(keyBytes));
            System.out.println("IV: " + Arrays.toString(ivbytes));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}