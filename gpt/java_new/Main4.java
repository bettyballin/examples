import org.bouncycastle.jce.provider.BouncyCastleProvider;
import java.security.KeyGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;
import javax.crypto.SecretKey;

public class Main4 {
    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchProviderException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("IDEA", "BC");
        keyGenerator.init(128);
        SecretKey key = keyGenerator.generateKey();
        // Use the generated key for cryptographic operations
    }
}