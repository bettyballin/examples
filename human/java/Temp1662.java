import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Temp1662 {
    public static void main(String[] args) {
        try {
            String key = "1234567890123456"; // 128 bit key
            String text = "Hello, World!";
            
            byte[] encrypted = encrypt(key.getBytes(), text.getBytes());
            System.out.println("Encrypted: " + new String(encrypted));
            
            byte[] decrypted = decrypt(key.getBytes(), encrypted);
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