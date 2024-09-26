import javax.crypto.Cipher;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.MGF1ParameterSpec;
import javax.crypto.spec.PSource;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class Temp3287 {
    public static void main(String[] args) {
        try {
            // Generate a RSA key pair
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048);
            KeyPair keyPair = keyPairGenerator.generateKeyPair();

            // Get Cipher instance
            Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPPadding");

            // Create OAEPParameterSpec
            OAEPParameterSpec oaepParameterSpec = new OAEPParameterSpec(
                    "SHA-256",
                    "MGF1",
                    new MGF1ParameterSpec("SHA-1"),
                    PSource.PSpecified.DEFAULT
            );

            // Initialize Cipher in ENCRYPT_MODE
            cipher.init(Cipher.ENCRYPT_MODE, keyPair.getPublic(), oaepParameterSpec);

            // Example data to encrypt
            byte[] data = "Hello, World!".getBytes();
            byte[] encryptedData = cipher.doFinal(data);

            System.out.println("Encrypted Data: " + new String(encryptedData));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}