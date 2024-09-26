import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Security;
import java.security.interfaces.ECPublicKey;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class ECCKeyPairGenerator {
    static {
        Security.addProvider(new BouncyCastleProvider());
    }
    
    public static void main(String[] args) throws Exception {
        KeyPair keyPair = generateECKeyPair();
        ECPublicKey publicKey = (ECPublicKey) keyPair.getPublic();
        // The rest of your code to utilize the publicKey
    }

    public static KeyPair generateECKeyPair() throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("ECDSA", BouncyCastleProvider.PROVIDER_NAME);
        keyPairGenerator.initialize(new ECGenParameterSpec("prime256v1"), new SecureRandom());
        return keyPairGenerator.generateKeyPair();
    }
}