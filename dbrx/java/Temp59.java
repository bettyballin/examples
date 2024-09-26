import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.Provider;

public class Temp59 {
    public static void main(String[] args) {
        try {
            Provider provider = java.security.Security.getProvider("SunJCE");
            KeyGenerator keyGen = KeyGenerator.getInstance("AES", provider);
            keyGen.init(256);
            SecretKey secretKey = keyGen.generateKey();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}