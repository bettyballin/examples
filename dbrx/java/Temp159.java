import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Temp159 {
    public static void main(String[] args) {
        try {
            byte[] iv = generateIV();
            System.out.println("Generated IV: " + java.util.Arrays.toString(iv));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public static byte[] generateIV() throws NoSuchAlgorithmException {
        SecureRandom secureRandom = SecureRandom.getInstanceStrong();
        byte[] ivBytes = new byte[16]; // 128 bits adjust as needed.
        secureRandom.nextBytes(ivBytes);
        return ivBytes;
    }
}