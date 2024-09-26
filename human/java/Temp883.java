import java.io.FileWriter;
import java.io.IOException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

import org.bouncycastle.openssl.jcajce.JcaPEMWriter;

public class Temp883 {
    public static void main(String[] args) {
        try {
            JcaPEMWriter writer = new JcaPEMWriter(new FileWriter("test.pem"));
            KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
            kpg.initialize(3072);
            KeyPair keyPair = kpg.generateKeyPair();
            writer.writeObject(keyPair.getPublic());
            writer.close();
        } catch (IOException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}