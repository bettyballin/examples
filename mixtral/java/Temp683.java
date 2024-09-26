import java.security.KeyStore;
import java.security.Security;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import java.io.FileInputStream;
import java.io.InputStream;

public class Temp683 {
    public static void main(String[] args) {
        try {
            Security.addProvider(new BouncyCastleProvider());
            KeyStore ks = KeyStore.getInstance("JKS");
            try (InputStream is = new FileInputStream("keystore.jks")) {
                ks.load(is, "password".toCharArray());
            }
            System.out.println("Keystore loaded successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}