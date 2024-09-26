import org.bouncycastle.openssl.PEMParser;
import org.bouncycastle.openssl.PEMEncryptedKeyPair;
import org.bouncycastle.openssl.PEMKeyPair;
import org.bouncycastle.openssl.jcajce.JcaPEMKeyConverter;

import java.io.FileReader;
import java.io.IOException;
import java.security.PrivateKey;

public class Temp2096 {
    public static void main(String[] args) {
        PrivateKey privKey = null;

        try (PEMParser pemParser = new PEMParser(new FileReader("private.key"))) {
            Object o = pemParser.readObject();

            if (!(o instanceof PEMEncryptedKeyPair))
                throw new IllegalArgumentException("Not a encrypted private key");

            PEMEncryptedKeyPair encryptedKeyPair = (PEMEncryptedKeyPair) o;
            JcaPEMKeyConverter converter = new JcaPEMKeyConverter();
            PEMKeyPair pemKeyPair = encryptedKeyPair.decryptKeyPair(null); // Replace null with appropriate password
            privKey = converter.getPrivateKey(pemKeyPair.getPrivateKeyInfo());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Use privKey as needed
    }
}