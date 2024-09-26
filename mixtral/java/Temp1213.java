import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.security.NoSuchAlgorithmException;

public class Temp1213 {
    public static void main(String[] args) {
        try {
            // Generate a secret key for encryption
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(128); // for example, 128-bit AES
            SecretKey secretKey = keyGen.generateKey();

            // Initialize the cipher for encryption
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            try (CipherOutputStream cipherOutputStream = new CipherOutputStream(
                    new BufferedOutputStream(new FileOutputStream("path/to/file")), cipher)) {
                ObjectOutput outputStream = new ObjectOutputStream(cipherOutputStream);

                // Write your sealed object here
                outputStream.writeObject("Your sealed object here");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}