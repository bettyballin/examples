import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Security;

public class Temp173 {
    public static void main(String[] args) throws Exception {
        // Add BC provider at runtime (if not already added)
        Security.addProvider(new BouncyCastleProvider());

        KeyPairGenerator kpg = KeyPairGenerator.getInstance("EC", "BC");
        kpg.initialize(256); // 192, 224 or 521 are also valid
        KeyPair kp = kpg.generateKeyPair();
        
        System.out.println("Key pair generated successfully.");
    }
}