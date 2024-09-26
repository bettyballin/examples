import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;

public class Temp453 {
    public static void main(String[] args) {
        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            kgen.init(256);
            SecretKey secretKey = kgen.generateKey();
            byte[] rawData = secretKey.getEncoded();
            String encodedKey = Base64.getUrlEncoder().withoutPadding().encodeToString(rawData);
            System.out.println("Encoded Key: " + encodedKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}