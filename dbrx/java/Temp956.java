import org.apache.ws.security.components.crypto.Crypto;
import org.apache.ws.security.components.crypto.Merlin;

import java.io.FileInputStream;
import java.security.KeyStore;

public class Temp956 {
    public static void main(String[] args) {
        try {
            // Replace with the actual path to your .pfx file and the password
            String pfxFile = "path/to/your/file.pfx";
            String password = "your_password";

            KeyStore keyStore = KeyStore.getInstance("PKCS12");
            keyStore.load(new FileInputStream(pfxFile), password.toCharArray());

            Crypto crypto = new Merlin();
            ((Merlin) crypto).setKeyStore(keyStore);

            System.out.println("KeyStore successfully loaded and set in Crypto instance.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}