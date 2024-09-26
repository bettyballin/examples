import javax.crypto.Cipher;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.MGF1ParameterSpec;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.spec.PSource;

public class Temp141 {
    public static void main(String[] args) {
        try {
            Cipher c = Cipher.getInstance("RSA/ECB/OAEPPadding");

            // Create OAEP parameters
            OAEPParameterSpec oaepParams = new OAEPParameterSpec(
                "SHA-1", // hash algorithm
                "MGF1",  // mask generation function
                MGF1ParameterSpec.SHA1,   // mgf hash algorithm
                PSource.PSpecified.DEFAULT);

            // Generate a key pair (for demonstration purposes)
            KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
            keyPairGen.initialize(2048);
            KeyPair keyPair = keyPairGen.generateKeyPair();
            PrivateKey privateKey = keyPair.getPrivate();

            // Initialize the cipher
            c.init(Cipher.DECRYPT_MODE, privateKey, oaepParams);

            System.out.println("Cipher initialized successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}