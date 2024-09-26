import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.io.FileInputStream;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.Security;

public class Temp450 {
    public static void main(String[] args) {
        try {
            Security.addProvider(new BouncyCastleProvider());

            KeyStore keyStore = KeyStore.getInstance("PKCS12", "BC");
            try (InputStream inputStream = new FileInputStream("keystore.p12")) {
                keyStore.load(inputStream, "password".toCharArray());
            }

            // Add your additional code here

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}