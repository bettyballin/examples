import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class Main5 {
    public static void main(String[] args) throws Exception {
        KeyGenerator aes = KeyGenerator.getInstance("AES");
        aes.init(128);
        SecretKey secret = aes.generateKey();
    }
}