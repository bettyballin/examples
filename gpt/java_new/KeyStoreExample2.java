import java.security.KeyStore;
import java.io.FileInputStream;
import java.io.InputStream;

public class KeyStoreExample2 {

    public static void main(String[] args) {
        try {
            KeyStore keystore = KeyStore.getInstance(KeyStore.getDefaultType());
            String keystorePath = System.getProperty("java.home") + "/lib/security/cacerts";
            char[] keystorePassword = "changeit".toCharArray();
            
            try (InputStream keystoreStream = new FileInputStream(keystorePath)) {
                keystore.load(keystoreStream, keystorePassword);
            }
            
            System.out.println("Keystore has " + keystore.size() + " entries");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}