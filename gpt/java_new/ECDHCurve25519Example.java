import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.crypto.generators.X25519KeyPairGenerator;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.params.X25519PublicKeyParameters;
import org.bouncycastle.crypto.params.X25519PrivateKeyParameters;
import java.security.SecureRandom;
import java.security.Security;

public class ECDHCurve25519Example {
    public static void main(String[] args) {
        Security.addProvider(new BouncyCastleProvider());

        X25519KeyPairGenerator keyPairGenerator = new X25519KeyPairGenerator();
        keyPairGenerator.init(new org.bouncycastle.crypto.KeyGenerationParameters(new SecureRandom(), 256));
        
        AsymmetricCipherKeyPair keyPair = keyPairGenerator.generateKeyPair();
        X25519PublicKeyParameters publicKey = (X25519PublicKeyParameters) keyPair.getPublic();
        X25519PrivateKeyParameters privateKey = (X25519PrivateKeyParameters) keyPair.getPrivate();
        
        // Use the generated public and private keys for your cryptographic operations
    }
}