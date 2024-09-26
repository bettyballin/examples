import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;

public class Temp1173 {
    public static void main(String[] args) {
        try {
            SecretKey aesKey = KeyGenerator.getInstance("AES").generateKey();
            System.out.println("AES Key generated: " + aesKey);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}