import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;

public class Temp2660 {

    private static final String key = "1234567890123456"; // 16-byte key for AES
    private static final String algo = "AES";

    public static void main(String[] args) {
        try {
            String text = "Hello, World!";
            String encrypted = encrypt(text);
            String decrypted = decrypt(encrypted);

            System.out.println("Original: " + text);
            System.out.println("Encrypted: " + encrypted);
            System.out.println("Decrypted: " + decrypted);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String encrypt(String text) throws Exception {
        SecretKeySpec sksSpec = new SecretKeySpec(key.getBytes(), algo);
        Cipher cipher = Cipher.getInstance(algo);
        cipher.init(javax.crypto.Cipher.ENCRYPT_MODE, sksSpec);

        byte[] encrypt_bytes = cipher.doFinal(text.getBytes());
        return new String(Base64.encodeBase64(encrypt_bytes));
    }

    public static String decrypt(String encrypt_str) throws Exception {
        SecretKeySpec sksSpec = new SecretKeySpec(key.getBytes(), algo);
        Cipher cipher = Cipher.getInstance(algo);
        cipher.init(Cipher.DECRYPT_MODE, sksSpec);

        return new String(cipher.doFinal(Base64.decodeBase64(encrypt_str.getBytes("UTF-8"))));
    }
}