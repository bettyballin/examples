import java.io.FileInputStream;
import java.security.KeyStore;

public class Temp2500 {
    public static void main(String[] args) {
        try {
            KeyStore keyStore = KeyStore.getInstance("PKCS12");
            keyStore.load(new FileInputStream("/path/to/keystore.p12"), "your_password".toCharArray());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}