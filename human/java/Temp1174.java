import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;

public class Temp1174 {
    public static void main(String[] args) {
        try {
            SecretKey key = generateSecretKey();
            System.out.println("Secret Key Generated: " + key);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public static SecretKey generateSecretKey() throws NoSuchAlgorithmException {
        KeyGenerator keyGener = KeyGenerator.getInstance("AES");
        keyGener.init(256); // here you can pass any valid length
        return keyGener.generateKey();
    }
}