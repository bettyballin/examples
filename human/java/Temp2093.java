import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;

public class Temp2093 {
    public static void main(String[] args) {
        try {
            KeyGenerator gen = KeyGenerator.getInstance("DESede");
            gen.init(112);
            SecretKey key = gen.generateKey();
            System.out.println("Key generated: " + key);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}