import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.spec.KeySpec;
import java.util.Base64;

public class Temp205 {
    public static void main(String[] args) {
        try {
            String content = "Hello, World!";
            char[] password = "password".toCharArray();
            String encrypted = encrypt(content, password);
            System.out.println("Encrypted: " + encrypted);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String encrypt(String content, char[] password) throws Exception {
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");

        KeySpec spec = new PBEKeySpec(password, "salt".getBytes(), 65536, 128);

        SecretKey tmp = factory.generateSecret(spec);

        byte[] keyData = new byte[16];

        System.arraycopy(tmp.getEncoded(), 0, keyData, 0, 16);

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

        SecretKeySpec secretKey = new SecretKeySpec(keyData, "AES");

        byte[] ivBytes = {0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 
                          0x08, 0x09, 0x0A, 0x0B, 0x0C, 0x0D, 0x0E, 0x0F};

        cipher.init(Cipher.ENCRYPT_MODE, secretKey, new javax.crypto.spec.IvParameterSpec(ivBytes));

        byte[] encrypted = cipher.doFinal(content.getBytes());

        return Base64.getEncoder().encodeToString(encrypted);
    }
}