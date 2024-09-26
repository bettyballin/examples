import org.apache.commons.codec.digest.DigestUtils;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class Main60 {
    public static void main(String[] args) {
        String str = "F6A5230232062D2F0BDC2080021E997C6D07A733004287544C9DDE7708975525";
        try {
            String key = DigestUtils.sha1Hex("test").substring(0, 32);
            String iv = str.substring(0, 32);
            String encryptedData = str.substring(32);
            byte[] cipherData = hexStringToByteArray(encryptedData);
            byte[] keyBytes = hexStringToByteArray(key);
            byte[] ivBytes = hexStringToByteArray(iv);

            SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, new IvParameterSpec(ivBytes));
            byte[] decrypted = cipher.doFinal(cipherData);

            String decryptedText = new String(decrypted);
            System.out.println("Result: " + decryptedText);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i + 1), 16));
        }
        return data;
    }
}