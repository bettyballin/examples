import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

public class Temp3011 {
    public static void main(String[] args) {
        try {
            KeyPairGenerator keyPairGenerator = getInstance("RSA");
            System.out.println("KeyPairGenerator instance created successfully.");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public static KeyPairGenerator getInstance(String algorithm) throws NoSuchAlgorithmException {
        return KeyPairGenerator.getInstance(algorithm);
    }
}