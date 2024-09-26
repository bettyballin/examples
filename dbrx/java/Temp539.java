import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openssl.PEMEncryptedKeyPair;
import org.bouncycastle.openssl.PEMKeyPair;
import org.bouncycastle.openssl.PEMParser;
import org.bouncycastle.openssl.jcajce.JcaPEMKeyConverter;
import org.bouncycastle.openssl.jcajce.JcePEMDecryptorProviderBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.Security;

public class Temp539 {
    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    public static void main(String[] args) {
        try {
            PrivateKey privateKey = privateKeyRead("path/to/your/private/key.pem");
            System.out.println(privateKey);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static PrivateKey privateKeyRead(String filename) throws IOException {
        try (FileReader reader = new FileReader(filename)) {
            PEMParser parser = new PEMParser(reader);

            Object obj = parser.readObject();
            JcaPEMKeyConverter converter = new JcaPEMKeyConverter();

            KeyPair kp;
            if (obj instanceof PEMEncryptedKeyPair) {
                PEMEncryptedKeyPair encryptedKeyPair = (PEMEncryptedKeyPair) obj;
                kp = converter.getKeyPair(encryptedKeyPair.decryptKeyPair(new JcePEMDecryptorProviderBuilder().build("your_password".toCharArray())));
            } else {
                kp = converter.getKeyPair((PEMKeyPair) obj);
            }

            return kp.getPrivate();
        }
    }
}