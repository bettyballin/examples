import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;

public class KeyGeneratorExample {
    public static SecretKey generateSecretKey() throws NoSuchAlgorithmException {  
        KeyGenerator keyGener = KeyGenerator.getInstance("AES");
        keyGener.init(256); // here you can pass any valid length
        return keyGener.generateKey();
    }
}