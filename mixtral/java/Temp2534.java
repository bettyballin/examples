import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.spec.KeySpec;

public class Temp2534 {
    public static void main(String[] args) {
        try {
            char[] password = "some_random_password".toCharArray();
            byte[] salt = new byte[16]; // Ideally, you should use a secure random salt
            int iterations = 1000;
            int keyLength = 256;

            KeySpec keySpec = new PBEKeySpec(password, salt, iterations, keyLength);
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            byte[] key = factory.generateSecret(keySpec).getEncoded();

            System.out.println("Generated key: " + bytesToHex(key));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}