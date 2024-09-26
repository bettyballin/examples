import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.ByteArrayOutputStream;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class AESCipherExample {

    public static void main(String[] args) throws Exception {
        // Sample encrypted data
        byte[] encrypted1 = "SampleEncryptedText".getBytes("UTF-8");
        byte[] expected = "SampleDecryptedText".getBytes("UTF-8");

        // Generate AES key
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128); // for example
        SecretKey secretKey = keyGen.generateKey();

        // Initialize the Cipher
        Cipher AESCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        AESCipher.init(Cipher.DECRYPT_MODE, secretKey);

        ByteArrayOutputStream bytesStream = new ByteArrayOutputStream();

        byte[] dec1 = AESCipher.update(encrypted1);
        if (dec1 != null) {
            bytesStream.write(dec1, 0, dec1.length);
        }

        // Always call doFinal to ensure all remaining data is processed
        byte[] finalBytes = AESCipher.doFinal();
        if (finalBytes != null) {
            bytesStream.write(finalBytes, 0, finalBytes.length);
        }

        String r = new String(bytesStream.toByteArray(), "UTF-8");
        System.out.println("Decrypted text: " + r);

        // Assuming the expected result as byte array for comparison
        assert Arrays.equals(expected, bytesStream.toByteArray());
    }
}