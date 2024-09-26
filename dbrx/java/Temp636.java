import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;

import org.bouncycastle.openssl.PEMParser;
import org.bouncycastle.openssl.jcajce.JcaPEMKeyConverter;
import org.bouncycastle.pkcs.PKCSException;
import org.bouncycastle.pkcs.PKCS8EncodedKeySpec;
import org.bouncycastle.openssl.PEMKeyPair;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;

public class Temp636 {
    public static void main(String[] args) {
        // Example usage (requires a real private key InputStream)
        // InputStream privateKeyInputStream = ...;
        // try {
        //     PrivateKey privateKey = new Temp636().loadPrivatekey(privateKeyInputStream);
        //     System.out.println("Private Key: " + privateKey);
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }
    }

    public PrivateKey loadPrivatekey(InputStream privateKeyInputStream)
            throws InvalidKeySpecException, NoSuchAlgorithmException, IOException {
        PEMParser parser = new PEMParser(new InputStreamReader(privateKeyInputStream));
        Object obj = parser.readObject();
        parser.close();
        if (obj instanceof PEMKeyPair) {
            PEMKeyPair keyPair = (PEMKeyPair) obj;
            PrivateKeyInfo privateKeyInfo = keyPair.getPrivateKeyInfo();
            return new JcaPEMKeyConverter().getPrivateKey(privateKeyInfo);
        } else if (obj instanceof PrivateKeyInfo) {
            return new JcaPEMKeyConverter().getPrivateKey((PrivateKeyInfo) obj);
        }
        throw new InvalidKeySpecException("Unsupported key format");
    }
}