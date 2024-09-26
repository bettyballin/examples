import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Security;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class Temp1941 {
    public static void main(String[] args) throws Exception {
        Security.addProvider(new BouncyCastleProvider());
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("XDH", "BC");
        kpg.initialize(256, new SecureRandom());
        KeyPair keyPair = kpg.generateKeyPair();
        PublicKey ourPk1 = keyPair.getPublic();
        PrivateKey private_key1 = keyPair.getPrivate();

        System.out.println("Public Key: " + ourPk1);
        System.out.println("Private Key: " + private_key1);
    }
}