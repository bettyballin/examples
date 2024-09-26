import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;

public class KeyLoader {
    public void loadPrivateKey(String filename) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        FileInputStream privateFis = null;
        try {
            privateFis = new FileInputStream(filename);
            byte[] privateKeyBytes = new byte[privateFis.available()];
            if (privateFis.read(privateKeyBytes) > 0) {
                PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(privateKeyBytes);
                KeyFactory keyFactory = KeyFactory.getInstance("RSA");
                RSAPrivateKey privKey = (RSAPrivateKey) keyFactory.generatePrivate(spec);
                BigInteger pKeyModulus = privKey.getModulus();
                // Use pKeyModulus for something
            }
        } finally {
            if (privateFis != null) {
                privateFis.close();
            }
        }
    }
}