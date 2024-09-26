import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Arrays;
import java.util.Base64;

public class Temp179 {
    public static void main(String[] args) throws Exception {
        String key = "someData";
        byte[] rawKey = Arrays.copyOf(key.getBytes(), 16);
        SecretKeySpec sks = new SecretKeySpec(rawKey, "AES");

        Cipher c = Cipher.getInstance("AES/ECB/PKCS5Padding");
        c.init(Cipher.ENCRYPT_MODE, sks);
        byte[] encodedBytes = c.doFinal(key.getBytes());
        String encodedString = Base64.getEncoder().encodeToString(encodedBytes);

        System.out.println(encodedString);
    }
}