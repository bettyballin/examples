import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jcajce.provider.asymmetric.ec.BCECPrivateKey;
import org.bouncycastle.jcajce.provider.asymmetric.rsa.BCRSAPrivateKey;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.Security;
import java.security.spec.PKCS8EncodedKeySpec;

public class PrivateKeyLoader {
    public static void main(String[] args) throws Exception {
        Security.addProvider(new BouncyCastleProvider());

        byte[] pkcs8key = new byte[]{ /* your PKCS#8 encoded private key data */ };

        KeyFactory factory = KeyFactory.getInstance("EC", "BC");
        PrivateKey privateKey = factory.generatePrivate(new PKCS8EncodedKeySpec(pkcs8key));

        if (privateKey instanceof BCECPrivateKey) {
            System.out.println("It's an EC private key");
        } else if (privateKey instanceof BCRSAPrivateKey) {
            System.out.println("It's a RSA private key");
        }
    }
}