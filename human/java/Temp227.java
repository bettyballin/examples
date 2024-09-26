import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Temp227 {
    public static void main(String[] args) {
        try {
            byte[] key = "1234567890123456".getBytes(); // 16-byte key for AES
            byte[] clearText = "Hello, World!".getBytes();

            byte[] encrypted = encrypt(key, clearText);
            System.out.println("Encrypted: " + new String(encrypted));

            byte[] decrypted = decrypt(key, encrypted);
            System.out.println("Decrypted: " + new String(decrypted));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static byte[] encrypt(byte[] raw, byte[] clear) throws Exception {
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        return cipher.doFinal(clear);
    }

    private static byte[] decrypt(byte[] raw, byte[] encrypted) throws Exception {
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, skeySpec);
        return cipher.doFinal(encrypted);
    }
}