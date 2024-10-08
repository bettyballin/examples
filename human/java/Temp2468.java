import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.util.concurrent.ThreadLocalRandom;

public class Temp2468 {
    public static void main(String[] args) {
        try {
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
            keyGen.initialize(2048);

            KeyPair keyPair = keyGen.generateKeyPair();
            PublicKey publicKey = keyPair.getPublic();
            PrivateKey privateKey = keyPair.getPrivate();

            // create a challenge
            byte[] challenge = new byte[10000];
            ThreadLocalRandom.current().nextBytes(challenge);

            // sign using the private key
            Signature sig = Signature.getInstance("SHA256withRSA");
            sig.initSign(privateKey);
            sig.update(challenge);
            byte[] signature = sig.sign();

            // verify signature using the public key
            sig.initVerify(publicKey);
            sig.update(challenge);

            boolean keyPairMatches = sig.verify(signature);
            System.out.println("Signature verification: " + keyPairMatches);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}