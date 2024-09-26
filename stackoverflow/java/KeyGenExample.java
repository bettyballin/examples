import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class KeyGenExample {
    public static void main(String[] args) throws Exception {
        KeyGenerator keygenerator = KeyGenerator.getInstance("Blowfish");
        SecretKey secretkey = keygenerator.generateKey();
    }
}