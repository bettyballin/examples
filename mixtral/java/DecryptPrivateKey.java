import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openssl.PEMEncryptedKeyPair;
import org.bouncycastle.openssl.PEMKeyPair;
import org.bouncycastle.openssl.PEMParser;
import org.bouncycastle.openssl.jcajce.JcaPEMKeyConverter;
import org.bouncycastle.openssl.jcajce.JcePEMDecryptorProviderBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.security.PrivateKey;
import java.security.Security;

public class DecryptPrivateKey {

    public static void main(String[] args) throws Exception {
        Security.addProvider(new BouncyCastleProvider());

        String encryptedPemFile = "enc_private.key";
        char[] password = "password".toCharArray();

        PEMParser pemParser = new PEMParser(new FileReader(encryptedPemFile));

        Object object = pemParser.readObject();

        if (object instanceof PEMEncryptedKeyPair) {
            // Encrypted key - we will use provided password
            JcePEMDecryptorProviderBuilder decProvBuilder = new JcePEMDecryptorProviderBuilder();
            PEMKeyPair pemKeyPair = ((PEMEncryptedKeyPair) object).decryptKeyPair(decProvBuilder.build(password));

            PrivateKeyInfo privateKeyInfo = pemKeyPair.getPrivateKeyInfo();
            JcaPEMKeyConverter converter = new JcaPEMKeyConverter().setProvider("BC");
            PrivateKey privateKey = converter.getPrivateKey(privateKeyInfo);

            System.out.println("Private Key: " + privateKey);
        } else {
            throw new IOException("The provided file does not contain an encrypted key pair");
        }

        pemParser.close();
    }
}