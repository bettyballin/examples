import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class Temp1708 {

    public static void main(String[] args) throws Exception {
        // Dummy data for demonstration
        byte[] encrypted1 = "encryptedData1".getBytes(StandardCharsets.UTF_8);
        byte[] encrypted2 = "encryptedData2".getBytes(StandardCharsets.UTF_8);
        String expected = "decryptedData";

        // Generate a temporary AES key
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128);
        SecretKey secretKey = keyGen.generateKey();

        // Initialize Cipher
        Cipher AESCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        AESCipher.init(Cipher.DECRYPT_MODE, secretKey);

        // Create ByteArrayOutputStream
        ByteArrayOutputStream fullPlaintextStream = new ByteArrayOutputStream();

        // Decrypt and write to the stream
        byte[] dec1 = AESCipher.update(encrypted1);
        if (dec1 != null) fullPlaintextStream.write(dec1);

        byte[] dec2 = AESCipher.update(encrypted2);
        if (dec2 != null) fullPlaintextStream.write(dec2);

        byte[] dec3 = AESCipher.doFinal();
        if (dec3 != null) fullPlaintextStream.write(dec3);

        // Convert decrypted bytes to string
        String r = new String(fullPlaintextStream.toByteArray(), StandardCharsets.UTF_8);

        // Dummy assertion for demonstration
        // In actual code, you should replace this with a proper check
        if (expected.equals(r)) {
            System.out.println("Decryption successful: " + r);
        } else {
            System.out.println("Decryption failed. Expected: " + expected + ", but got: " + r);
        }
    }
}