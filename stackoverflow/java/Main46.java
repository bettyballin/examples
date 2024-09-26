import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class Main46 {
    public static void main(String[] args) throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        SecretKey aesKey = keyGen.generateKey();
    }
}