import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Temp64 {
    public static void main(String[] args) {
        try {
            KeyGenerator kg = KeyGenerator.getInstance("AES");
            kg.init(128, new SecureRandom()); // specify key size
            SecretKey sk = kg.generateKey();
            System.out.println("Secret Key: " + sk);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}