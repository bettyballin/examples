import java.security.*;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class Temp1840 {
    public static void main(String[] args) {
        Security.addProvider(new BouncyCastleProvider());
        try {
            KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA", "BC");
            kpg.initialize(2048, new SecureRandom());
            KeyPair keyPair = kpg.generateKeyPair();
            System.out.println("Key pair generated successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}