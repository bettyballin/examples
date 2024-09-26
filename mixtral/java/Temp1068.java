import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.Security;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;

import org.apache.commons.io.IOUtils;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class Temp1068 {
    public static void main(String[] args) {
        try {
            Security.addProvider(new BouncyCastleProvider());

            FileInputStream fis = new FileInputStream("privatekey.xml");
            byte[] keyBytes = IOUtils.toByteArray(fis);

            PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);

            KeyFactory kf = KeyFactory.getInstance("RSA", "BC");
            PrivateKey privateKey = kf.generatePrivate(spec);

            // Print private key to verify it is loaded correctly (not recommended in production code)
            System.out.println(privateKey);
        } catch(IOException | InvalidKeySpecException | java.security.NoSuchAlgorithmException | java.security.NoSuchProviderException e) {
            e.printStackTrace();
        }
    }
}