import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.openssl.PEMParser;
import org.bouncycastle.openssl.jcajce.JcaPEMWriter;
import org.bouncycastle.openssl.PEMKeyPair;
import org.bouncycastle.openssl.PEMException;

public class Temp458 {
    public static void main(String[] args) {
        try {
            // Read the PKCS#1 PEM file
            FileReader reader = new FileReader("pkcs1_privatekey.pem");
            PEMParser pemParser = new PEMParser(reader);
            PEMKeyPair pemKeyPair = (PEMKeyPair) pemParser.readObject();

            // Convert PKCS#1 to PKCS#8
            PrivateKeyInfo privateKeyInfo = pemKeyPair.getPrivateKeyInfo();

            // Write the converted key in PKCS#8 format
            JcaPEMWriter pemWriter = new JcaPEMWriter(new FileWriter("pkcs8_privatekey.pem"));
            pemWriter.writeObject(privateKeyInfo);

            // Close the resources
            pemWriter.close();
            pemParser.close();
            reader.close();
        } catch (IOException | PEMException e) {
            e.printStackTrace();
        }
    }
}