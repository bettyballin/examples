import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Arrays;

public class Temp1831 {
    public static void main(String[] args) {
        try {
            String str = "F6A5230232062D2F0BDC2080021E997C6D07A733004287544C9DDE7708975525";

            // Extract IV and ciphertext from the input string
            String ivHex = str.substring(0, 32);
            String ciphertextHex = str.substring(32);

            // Convert IV and ciphertext to byte arrays
            byte[] iv = hexStringToByteArray(ivHex);
            byte[] ciphertext = hexStringToByteArray(ciphertextHex);

            // Create SHA1 hash of the key
            MessageDigest sha1 = MessageDigest.getInstance("SHA-1");
            byte[] keyBytes = Arrays.copyOf(sha1.digest("test".getBytes(StandardCharsets.UTF_8)), 16); // AES key length is 128 bits

            // Initialize cipher
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");
            IvParameterSpec ivSpec = new IvParameterSpec(iv);
            cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);

            // Decrypt the ciphertext
            byte[] decryptedBytes = cipher.doFinal(ciphertext);
            String decryptedText = new String(decryptedBytes, StandardCharsets.UTF_8);

            System.out.println("Result: " + decryptedText);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }
}