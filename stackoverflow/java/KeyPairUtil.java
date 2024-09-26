import java.math.BigInteger;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.KeyAgreement;
import java.security.*;

public class KeyPairUtil {
    public static void main(String[] args) {
        try {
            KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("DH");
            keyPairGen.initialize(2048);
            KeyPair dkp = keyPairGen.generateKeyPair();
            
            BigInteger x = ((DHPrivateKey) dkp.getPrivate()).getX();
            BigInteger y = ((DHPublicKey) dkp.getPublic()).getY();
            
            // Use x and y as needed
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}