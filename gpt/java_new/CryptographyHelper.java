import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;

public class CryptographyHelper {
    private KeyPairGenerator kpg;
    private SecureRandom sr;
    private KeyPair kp;
    private PublicKey PubKey;
    private PrivateKey PrivKey;

    public void init(int keySize) {
        try {
            sr = SecureRandom.getInstance("SHA1PRNG");
            kpg = KeyPairGenerator.getInstance("RSA");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return;
        }
        kpg.initialize(keySize, sr);

        kp = kpg.genKeyPair();
        PubKey = kp.getPublic();
        PrivKey = kp.getPrivate();
    }
    // Other methods...
}