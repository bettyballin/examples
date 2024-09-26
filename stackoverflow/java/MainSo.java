import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Arrays;

public class MainSo {
    public static void main(String[] args) {
        try {
            String plaintext = "HelloWorld";
            String keyString = "XXXXXXXX00000000"; // 16 chars
            byte[] key = keyString.getBytes(StandardCharsets.UTF_8);
            MessageDigest md = MessageDigest.getInstance("MD5");
            key = md.digest(key);
            key = Arrays.copyOf(key, 16); // use only first 128 bit
            SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            byte[] ciphertext = cipher.doFinal(plaintext.getBytes(StandardCharsets.UTF_8));
            System.out.println("ciphertext Java:   " + bytesToHex(ciphertext));
            System.out.println("ciphertext NodeJS: " + "ce25d577457cf8113fa4d9eb16379529");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte b : bytes) {
            result.append(String.format("%02x", b));
        }
        return result.toString();
    }
}