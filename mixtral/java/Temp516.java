import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.Arrays;

public class Temp516 {
    private static final String SECRET_KEY = "ThisIsASecretKey123"; // Example key
    private static final String stringedXmlForSending = "<xml>Example</xml>"; // Example data

    public static void main(String[] args) throws Exception {
        byte[] sessionKey = Arrays.copyOf(SECRET_KEY.getBytes(), 32);
        SecretKeySpec secretKeySpec = new SecretKeySpec(sessionKey, "AES");

        // Generate a random IV
        SecureRandom secureRandom = new SecureRandom();
        byte iv[] = new byte[16];
        secureRandom.nextBytes(iv);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
        byte[] encryptedText = cipher.doFinal(stringedXmlForSending.getBytes());

        System.out.println(Arrays.toString(encryptedText));
    }
}