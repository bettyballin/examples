import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class Temp2174 {
    public static void main(String[] args) throws Exception {

        // Generate original secret key
        SecretKey originalSK = KeyGenerator.getInstance("RC4").generateKey();

        // Convert to Base 64 encoded string
        String base64EncodedOriginalSk = Base64.getEncoder().encodeToString(originalSK.getEncoded());

        // Transmit/store this string

        // On receiving end

        // Decode the received base64 string
        byte[] decodedKeyBytes = Base64.getDecoder().decode(base64EncodedOriginalSk);

        // Create Secret Key Spec
        SecretKeySpec rebuiltSKS = new SecretKeySpec(decodedKeyBytes, "RC4");

        // Print to verify
        System.out.println("Original Key: " + base64EncodedOriginalSk);
        System.out.println("Rebuilt Key: " + Base64.getEncoder().encodeToString(rebuiltSKS.getEncoded()));
    }
}