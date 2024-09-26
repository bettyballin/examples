import java.security.KeyStore;
import java.io.FileInputStream;

public class Temp405 {
    public static void main(String[] args) {
        try (FileInputStream is = new FileInputStream("C:\\Users\\user\\Desktop\\keystore.p12")) {
            KeyStore keystore = KeyStore.getInstance("PKCS12");
            keystore.load(is, "password".toCharArray());
            System.out.println("Keystore loaded successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}