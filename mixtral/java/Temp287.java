import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.openssl.PEMEncryptedKeyPair;
import org.bouncycastle.openssl.PEMKeyPair;
import org.bouncycastle.openssl.PEMParser;
import org.bouncycastle.pkcs.jcajce.JcaPKCS8Generator;

import java.io.StringReader;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;

public class Temp287 {
    public static void main(String[] args) {
        // You can add some test code here if needed
    }

    private PrivateKey generatePrivateKey(String newKey) throws Exception {
        PEMParser pemParser = new PEMParser(new StringReader(newKey));

        Object object = pemParser.readObject();

        if (object instanceof PEMEncryptedKeyPair) {
            // Handle encrypted keys
            throw new IllegalArgumentException("Encrypted keys are not supported in this example.");
        } else if (object instanceof PrivateKeyInfo) {
            PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(
                    ((PrivateKeyInfo) object).getEncoded());

            KeyFactory kf = KeyFactory.getInstance("RSA");

            return kf.generatePrivate(spec);
        } else if (object instanceof PEMKeyPair) {
            // Handle key pairs
            throw new IllegalArgumentException("Key pairs are not supported in this example.");
        }

        throw new IllegalArgumentException("Unsupported key format.");
    }
}