import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.spec.SecretKeySpec;

public class Temp534 {
    public static void main(String[] args) {
        try {
            SecretKeySpec key = generateKey("string1", "string2");
            System.out.println("Key generated: " + java.util.Arrays.toString(key.getEncoded()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public static SecretKeySpec generateKey(String str1, String str2) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest((str1 + str2).getBytes(StandardCharsets.UTF_8));
        byte[] aesKey = new byte[32]; // AES key size is 32 bytes for AES-256
        System.arraycopy(hash, 0, aesKey, 0, Math.min(32, hash.length));
        return new SecretKeySpec(aesKey, "AES");
    }
}