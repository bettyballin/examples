import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class Temp168 {
    public static void main(String[] args) {
        char[] password = "password".toCharArray();
        byte[] salt = "12345678".getBytes();
        int iterationCount = 65536;
        int derivedKeyLength = 256;

        PBEKeySpec spec = new PBEKeySpec(password, salt, iterationCount, derivedKeyLength);
        try {
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            byte[] keyBytes = skf.generateSecret(spec).getEncoded();
            System.out.println("Derived key: " + bytesToHex(keyBytes));
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
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