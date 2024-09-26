import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidKeyException;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchProviderException;
import java.security.Security;
import java.util.Base64;

public class Temp1271 {
    public static void main(String[] args) {
        try {
            Cipher crypt = Cipher.getInstance("AES/CBC/PKCS5Padding");

            // Generate a key
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(128); // for example
            SecretKey secretKey = keyGen.generateKey();

            // Generate an initialization vector (IV)
            byte[] iv = new byte[crypt.getBlockSize()];
            IvParameterSpec ivParams = new IvParameterSpec(iv);

            // Initialize the cipher for encryption
            crypt.init(Cipher.ENCRYPT_MODE, secretKey, ivParams);

            // Example plaintext
            String plaintext = "Hello World";
            byte[] ciphertext = crypt.doFinal(plaintext.getBytes());

            // Print the ciphertext in Base64 encoding
            System.out.println("Ciphertext: " + Base64.getEncoder().encodeToString(ciphertext));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}