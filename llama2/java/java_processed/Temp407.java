import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

public class Temp407 {
    public static void main(String[] args) {
        // Example usage
        try {
            String password = "mysecretpassword";
            byte[] encryptedData = new byte[]{/* some encrypted data */};
            byte[] decryptedData = decrypt(encryptedData, password);
            System.out.println(new String(decryptedData));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static byte[] decrypt(byte[] data, String password) throws Exception {
        Key key = generateKey(password);
        Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
        cipher.init(Cipher.DECRYPT_MODE, key);
        return cipher.doFinal(data);
    }

    private static Key generateKey(String password) throws Exception {
        byte[] keyBytes = password.getBytes("UTF-8");
        if (keyBytes.length < 16) {
            byte[] newKeyBytes = new byte[16];
            System.arraycopy(keyBytes, 0, newKeyBytes, 0, keyBytes.length);
            keyBytes = newKeyBytes;
        }
        return new SecretKeySpec(keyBytes, 0, 16, "AES");
    }
}