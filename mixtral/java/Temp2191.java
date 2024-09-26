import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Security;
import net.i2p.crypto.eddsa.EdDSAPrivateKey;
import net.i2p.crypto.eddsa.EdDSASecurityProvider;

public class Temp2191 {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        Security.addProvider(new EdDSASecurityProvider());

        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("Ed25519");
        KeyPair keyPair = keyGen.generateKeyPair();
        PrivateKey privateKey = keyPair.getPrivate();

        byte[] privateKeyBytes = ((EdDSAPrivateKey) privateKey).getSeed();
        
        // Print the private key bytes for verification
        for (byte b : privateKeyBytes) {
            System.out.printf("%02x", b);
        }
    }
}