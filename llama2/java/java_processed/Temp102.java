import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.spec.KeySpec;

public class Temp102 {
    public static void main(String[] args) {
        try {
            char[] password = "password".toCharArray(); // Example password
            byte[] salt = "12345678".getBytes(); // Example salt

            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
            KeySpec spec = new PBEKeySpec(password, salt, 1, 128);
            System.out.println("SecretKeyFactory and KeySpec initialized successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}