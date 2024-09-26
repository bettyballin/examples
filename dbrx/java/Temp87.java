import javax.crypto.Cipher;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;

public class Temp87 {
    public static void main(String[] args) {
        try {
            // Generate a key pair for demonstration purposes
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
            keyGen.initialize(2048);
            KeyPair keyPair = keyGen.generateKeyPair();
            PrivateKey privateKey = keyPair.getPrivate();

            // Initialize the cipher
            Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            
            System.out.println("Cipher initialized successfully.");
        } catch (InvalidKeyException e) {
            // Handle invalid key exception here
            System.err.println("Invalid key: " + e.getMessage());
        } catch (NoSuchAlgorithmException | javax.crypto.NoSuchPaddingException e) {
            // Handle other potential exceptions here
            System.err.println("Error initializing cipher: " + e.getMessage());
        }
    }
}