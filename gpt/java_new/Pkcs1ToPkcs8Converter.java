import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.openssl.PEMParser;
import org.bouncycastle.openssl.PEMWriter;
import org.bouncycastle.openssl.jcajce.JcaPEMKeyConverter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.KeyPair;
import java.security.PrivateKey;

public class Pkcs1ToPkcs8Converter {

    public static void convertPkcs1ToPkcs8(String pkcs1KeyPath, String pkcs8KeyPath) throws IOException {
        // Read the PKCS#1 PEM file
        try (PEMParser pemParser = new PEMParser(new FileReader(pkcs1KeyPath))) {
            Object object = pemParser.readObject();

            PrivateKey privateKey;
            if (object instanceof PrivateKeyInfo) {
                privateKey = new JcaPEMKeyConverter().getPrivateKey((PrivateKeyInfo) object);
            } else if (object instanceof KeyPair) {
                privateKey = ((KeyPair) object).getPrivate();
            } else {
                throw new IllegalArgumentException("Unsupported key format!");
            }

            // Write the PKCS#8 PEM file
            try (Writer writer = new FileWriter(pkcs8KeyPath)) {
                PEMWriter pemWriter = new PEMWriter(writer);
                pemWriter.writeObject(privateKey);
                pemWriter.close();
            }
        }
    }
}