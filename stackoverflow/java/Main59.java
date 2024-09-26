import org.apache.commons.codec.digest.DigestUtils;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Main59 {
    public static void main(String[] args) {
        try {
            String str = "CB5E759CE5FEAFEFCC9BABBFD84DC80C0291ED4917CF1402FF03B8E12716E44C";
            byte[] key = DigestUtils.sha1("test");
            byte[] keyBytes = new byte[16];
            System.arraycopy(key, 0, keyBytes, 0, Math.min(key.length, 16));

            SecretKeySpec secretKey = new SecretKeySpec(keyBytes, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            IvParameterSpec ivSpec = new IvParameterSpec(hexStringToByteArray(str.substring(0, 32)));

            cipher.init(Cipher.DECRYPT_MODE, secretKey, ivSpec);
            byte[] decrypted = cipher.doFinal(hexStringToByteArray(str.substring(32)));

            System.out.println("Result: " + new String(decrypted, StandardCharsets.UTF_8));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                                 + Character.digit(s.charAt(i + 1), 16));
        }
        return data;
    }
}