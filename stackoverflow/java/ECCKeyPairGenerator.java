import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.spec.ECGenParameterSpec;

public class ECCKeyPairGenerator {
    public static void main(String[] args) {
        try {
            KeyPairGenerator kpGen = KeyPairGenerator.getInstance("EC");
            kpGen.initialize(new ECGenParameterSpec("secp384r1"));
            KeyPair ecKP = kpGen.generateKeyPair();
            // Use the generated key pair for your application
        } catch (NoSuchAlgorithmException e) {
            System.err.println("Algorithm not available: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error generating key pair: " + e.getMessage());
        }
    }
}