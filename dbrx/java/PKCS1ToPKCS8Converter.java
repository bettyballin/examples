import org.bouncycastle.openssl.PEMKeyPair;
import org.bouncycastle.openssl.PEMParser;
import org.bouncycastle.openssl.jcajce.JcaPEMWriter;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.io.FileReader;
import java.io.FileWriter;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.Security;
import java.security.spec.PKCS8EncodedKeySpec;

public class PKCS1ToPKCS8Converter {
    public static void main(String[] args) throws Exception {
        // Add BouncyCastle as a Security Provider
        Security.addProvider(new BouncyCastleProvider());

        // Read the private key in PEM format
        try (FileReader reader = new FileReader("private_key.pem");
             PEMParser parser = new PEMParser(reader)) {

            Object object = parser.readObject();
            KeyFactory factory = KeyFactory.getInstance("RSA", "BC");

            if (object instanceof PEMKeyPair) {
                PrivateKey privateKey = factory.generatePrivate(new PKCS8EncodedKeySpec(((PEMKeyPair) object).getPrivateKeyInfo().getEncoded()));

                // Write the private key in DER format
                try (FileWriter writer = new FileWriter("private_key.der");
                     JcaPEMWriter pemWriter = new JcaPEMWriter(writer)) {

                    pemWriter.writeObject(privateKey);
                }
            }
        }
    }
}