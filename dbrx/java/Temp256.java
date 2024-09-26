Here is the corrected code:


import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openssl.PEMKeyPair;
import org.bouncycastle.openssl.PEMParser;
import org.bouncycastle.openssl.jcajce.JcaPEMKeyConverter;

import java.io.StringReader;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.Security;

public class Temp256 {
    public static void main(String[] args) {
        String privateKeyPem = "-----BEGIN RSA PRIVATE KEY-----\n" +
                "MIIE...gNK3x\n" +
                "-----END RSA PRIVATE KEY-----";
        PrivateKey pk;

        Security.addProvider(new BouncyCastleProvider());

        try (PEMParser pemParser = new PEMParser(new StringReader(privateKeyPem))) {
            Object object = pemParser.readObject();
            JcaPEMKeyConverter converter = new JcaPEMKeyConverter().setProvider(BouncyCastleProvider.PROVIDER_NAME);
            KeyPair kp = converter.getKeyPair((PEMKeyPair) object);
            pk = kp.getPrivate();
            System.out.println("Private Key: " + pk);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}