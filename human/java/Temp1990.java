import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidKeyException;

public class Temp1990 {
    public static void main(String[] args) {
        try {
            // Generate a secret key
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(128); // Key size
            SecretKey secret = keyGen.generateKey();
            
            // Initialize the cipher
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secret);
            
            // Specify the file to be encrypted
            String choosedFile = "path/to/your/file.txt";
            InputStream is = new FileInputStream(choosedFile);
            OutputStream os = new CipherOutputStream(new FileOutputStream(choosedFile + ".encrypted"), cipher);
            
            // Encrypt the file
            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) != -1) {
                os.write(buffer, 0, len);
            }
            
            // Close the streams
            is.close();
            os.close();
        } catch (NoSuchAlgorithmException | InvalidKeyException | javax.crypto.NoSuchPaddingException | java.io.IOException e) {
            e.printStackTrace();
        }
    }
}