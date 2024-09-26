import org.bouncycastle.jce.provider.BouncyCastleProvider;
import java.security.*;
import java.security.spec.*;

public class ECDSAPublicKeyLoader {
    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    public PublicKey loadPublicKey(String publicKeyStr) throws GeneralSecurityException {
        KeyFactory factory = KeyFactory.getInstance("ECDSA", "BC");
        EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(java.util.Base64.getDecoder().decode(publicKeyStr));
        return factory.generatePublic(publicKeySpec);
    }
}