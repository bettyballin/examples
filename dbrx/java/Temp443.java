import org.bouncycastle.jce.provider.BouncyCastleProvider;
import java.security.KeyPairGenerator;
import java.security.KeyPair;
import java.security.PublicKey;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.Security;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

public class Temp443 {
    public static void main(String[] args) {
        try {
            Security.addProvider(new BouncyCastleProvider());

            KeyPairGenerator gen = KeyPairGenerator.getInstance("RSA", "BC");
            SecureRandom random = SecureRandom.getInstanceStrong(); // Use getInstanceStrong() for secure random number generation
            gen.initialize(4096, random);
            KeyPair keyPair = gen.generateKeyPair();
            PublicKey pubk = keyPair.getPublic();
            PrivateKey prvk = keyPair.getPrivate();

            System.out.println("Public Key: " + pubk.getEncoded()); // Use getEncoded() to print the key
            System.out.println("Private Key: " + prvk.getEncoded()); // Use getEncoded() to print the key

        } catch (NoSuchAlgorithmException | NoSuchProviderException e) {
            e.printStackTrace();
        }
    }
}