import java.io.FileInputStream;
import java.security.KeyStore;

public class Temp2569 {
    public static void main(String[] args) {
        try {
            KeyStore truststore = KeyStore.getInstance("JKS");
            truststore.load(new FileInputStream("/path/to/your/keystore"), "password".toCharArray());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}