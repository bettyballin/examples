import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Temp755 {
    private static final byte[] encryptionKeyBytes = "0123456789abcdef".getBytes(StandardCharsets.UTF_8);
    private static final SecretKeySpec encryptionKey = new SecretKeySpec(encryptionKeyBytes, "AES");
    private static final Cipher cipher;

    static {
        try {
            cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        try {
            String hexEncoded = "your_hex_encoded_string_here"; // replace with actual hex encoded string
            String decryptedText = decrypt(hexEncoded);
            System.out.println("Decrypted text: " + decryptedText);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String decrypt(String hexEncoded) throws Exception {
        byte[] decodedBytes = hexStringToBytes(hexEncoded);
        int ivIndex = decodedBytes.length - 16;
        cipher.init(Cipher.DECRYPT_MODE, encryptionKey, new IvParameterSpec(decodedBytes, ivIndex, 16));
        return new String(cipher.doFinal(decodedBytes, 0, ivIndex), StandardCharsets.UTF_8);
    }

    private static byte[] hexStringToBytes(String hexString) {
        int length = hexString.length();
        byte[] data = new byte[length / 2];
        for (int i = 0; i < length; i += 2) {
            data[i / 2] = (byte) ((Character.digit(hexString.charAt(i), 16) << 4)
                    + Character.digit(hexString.charAt(i + 1), 16));
        }
        return data;
    }
}