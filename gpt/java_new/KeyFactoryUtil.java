import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.Security;
import java.security.spec.PKCS8EncodedKeySpec;

public class KeyFactoryUtil {

    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    public static PrivateKey getPrivateKeyFromPKCS8(byte[] pkcs8Bytes) throws Exception {
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(pkcs8Bytes);
        PrivateKeyInfo pkInfo = PrivateKeyInfo.getInstance(pkcs8Bytes);
        AlgorithmIdentifier algId = pkInfo.getPrivateKeyAlgorithm();
        KeyFactory keyFactory = KeyFactory.getInstance(algId.getAlgorithm().getId(), "BC");
        return keyFactory.generatePrivate(keySpec);
    }
}