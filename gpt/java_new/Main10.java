import org.bouncycastle.jce.provider.BouncyCastleProvider;
import java.security.*;

public class Main10 {
    static {
        Security.addProvider(new BouncyCastleProvider());
    }
    
    public static void main(String[] args) {
        // Rest of the code...
        try {
            KeyPair keyPair = generateRSAKeyPair();
            // Use the keyPair...
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static KeyPair generateRSAKeyPair() throws Exception {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA", "BC");
        keyGen.initialize(2048, new SecureRandom());
        return keyGen.generateKeyPair();
    }
}