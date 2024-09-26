import javax.crypto.*;
import java.security.NoSuchAlgorithmException;

public class Temp1251 {
    public static void main(String[] args) {
        try {
            SecretKey key = generateTripleDESKey();
            System.out.println("Key generated: " + key);
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Error generating key: " + e.getMessage());
        }
    }

    public static SecretKey generateTripleDESKey() throws NoSuchAlgorithmException {
        KeyGenerator generator = KeyGenerator.getInstance("DESede");
        generator.init(168);
        return generator.generateKey();
    }
}