import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;

public class Temp70 {
    public static void main(String[] args) {
        try {
            KeyGenerator aes = KeyGenerator.getInstance("AES");
            aes.init(128);
            SecretKey secret = aes.generateKey();
            System.out.println("Secret Key: " + bytesToHex(secret.getEncoded()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}