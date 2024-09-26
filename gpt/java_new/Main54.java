import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.Base64;

public class Main54 {
    final static public String ENCRYPT_KEY = "4EBB854BC67649A99376A7B90089CFF1";
    final static public String IVKEY = "ECE7D4111337A511";

    public static void main(String[] args) throws Exception {
        String toEncrypt = "Hello, World!";
        byte[] encrypted = encrypt(toEncrypt, ENCRYPT_KEY, IVKEY);
        System.out.println("Encrypted: " + Base64.getEncoder().encodeToString(encrypted));
    }

    public static byte[] encrypt(String toEncrypt, String key, String iv) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes("UTF-8"));
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivParameterSpec);
        return cipher.doFinal(toEncrypt.getBytes("UTF-8"));
    }
}