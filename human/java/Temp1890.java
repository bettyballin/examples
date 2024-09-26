import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;

public class Temp1890 {
    public static void main(String[] args) {
        try {
            KeyGenerator keygenerator = KeyGenerator.getInstance("Blowfish");
            SecretKey secretkey = keygenerator.generateKey();
            System.out.println("Key generated successfully: " + secretkey);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}