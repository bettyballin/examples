import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.nio.charset.StandardCharsets;
import java.security.AlgorithmParameters;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidParameterSpecException;
import java.util.Base64;

public class EncryptMessage {
    public static void main(String[] args) {
        try {
            // Generate a secret key
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(128); // for example, 128-bit AES
            SecretKey secret = keyGen.generateKey();

            // Encrypt the message
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secret);
            AlgorithmParameters params = cipher.getParameters();
            byte[] iv = params.getParameterSpec(IvParameterSpec.class).getIV();
            byte[] ciphertext = cipher.doFinal("Hello, World!".getBytes(StandardCharsets.UTF_8));

            // Print the results
            System.out.println("IV: " + Base64.getEncoder().encodeToString(iv));
            System.out.println("Ciphertext: " + Base64.getEncoder().encodeToString(ciphertext));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}