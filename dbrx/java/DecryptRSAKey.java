import org.bouncycastle.openssl.PEMDecryptorProvider;
import org.bouncycastle.openssl.PEMEncryptedKeyPair;
import org.bouncycastle.openssl.PEMKeyPair;
import org.bouncycastle.openssl.PEMParser;
import org.bouncycastle.openssl.jcajce.JcaPEMKeyConverter;
import org.bouncycastle.openssl.jcajce.JcePEMDecryptorProviderBuilder;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.io.FileReader;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.Security;

public class DecryptRSAKey {
    public static void main(String[] args) throws Exception {
        // Add BouncyCastle as a security provider
        Security.addProvider(new BouncyCastleProvider());

        String keyFile = "enc_private.key";
        String passphrase = "<PASSWORD>";

        PEMParser parser = new PEMParser(new FileReader(keyFile));
        Object object = parser.readObject();
        parser.close(); // Close the parser after reading

        JcaPEMKeyConverter converter = new JcaPEMKeyConverter().setProvider("BC");
        KeyPair kp;

        if (object instanceof PEMEncryptedKeyPair) {
            PEMDecryptorProvider decProv = new JcePEMDecryptorProviderBuilder()
                    .build(passphrase.toCharArray());
            kp = converter.getKeyPair(((PEMEncryptedKeyPair) object).decryptKeyPair(decProv));
        } else if (object instanceof PEMKeyPair) {
            // Handle non-encrypted key pairs
            kp = converter.getKeyPair((PEMKeyPair) object);
        } else {
            throw new IllegalArgumentException("Unsupported key format");
        }

        // Now you have the decrypted private key in 'kp.getPrivate()'
        PrivateKey privateKey = kp.getPrivate();
        System.out.println("Decrypted Private Key: " + privateKey);
    }
}