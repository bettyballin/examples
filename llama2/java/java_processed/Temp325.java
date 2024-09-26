import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Temp325 {
    public static void main(String[] args) {

        String key = "00000000000000000000000000000000"; // 128-bit key consisting of all zeros
        byte[] keyBytes = new BigInteger(key, 16).toByteArray();
        // Ensure the key array is exactly 16 bytes (128 bits)
        if (keyBytes.length > 16) {
            keyBytes = Arrays.copyOfRange(keyBytes, keyBytes.length - 16, keyBytes.length);
        } else if (keyBytes.length < 16) {
            byte[] temp = new byte[16];
            System.arraycopy(keyBytes, 0, temp, 16 - keyBytes.length, keyBytes.length);
            keyBytes = temp;
        }
        SecretKeySpec secretKey = new SecretKeySpec(keyBytes, "AES");

        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] plaintext = "Hello World!".getBytes(StandardCharsets.UTF_8);
            // Pad plaintext to be a multiple of 16 bytes
            byte[] paddedPlaintext = new byte[16];
            System.arraycopy(plaintext, 0, paddedPlaintext, 0, plaintext.length);
            byte[] ciphertext = cipher.doFinal(paddedPlaintext);

            javax.xml.bind.DatatypeConverter.printHexBinary(ciphertext);
            System.out.println("Ciphertext: " + javax.xml.bind.DatatypeConverter.printHexBinary(ciphertext));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}