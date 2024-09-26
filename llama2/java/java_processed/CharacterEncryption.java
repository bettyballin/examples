import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Arrays;

public class CharacterEncryption {
    public static void main(String[] args) throws Exception {
        String str = "312432432";
        String key = "1234567890123456"; // AES requires 16-byte key

        // Define the allowed characters
        char[] allowedChars = "0123456789".toCharArray();

        // Create a Key from the given key
        Key secretKey = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

        // Initialize the Cipher
        Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        // Encrypt each character of the plaintext
        char[] plaintextChars = str.toCharArray();
        StringBuffer encryptedText = new StringBuffer();
        for (int i = 0; i < plaintextChars.length; i++) {
            char c = plaintextChars[i];
            if (Arrays.binarySearch(allowedChars, c) >= 0) {
                // Encrypt the character
                byte[] encryptedByte = cipher.doFinal(new byte[]{(byte) c});
                encryptedText.append(new String(encryptedByte, "ISO-8859-1"));
            }
        }
        System.out.println("Encrypted Text: " + encryptedText.toString());
    }
}