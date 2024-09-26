import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Temp2006 {
    public static void main(String[] args) {
        try {
            // For simplicity, using a hardcoded key. In a real-world scenario, manage keys securely.
            String key = "1234567890123456"; // 128 bit key
            SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");

            // Initialize Cipher
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);

            // Prepare streams
            FileInputStream fis = new FileInputStream("encryptedfile.dat");
            CipherInputStream cipherInputStream = new CipherInputStream(fis, cipher);
            FileOutputStream fos = new FileOutputStream("decryptedfile.dat");

            // Decrypt and write to file
            byte[] decodedByteChunk = new byte[1024];
            int bytesAvailable = cipherInputStream.read(decodedByteChunk);
            while (bytesAvailable != -1) {
                fos.write(decodedByteChunk, 0, bytesAvailable);
                bytesAvailable = cipherInputStream.read(decodedByteChunk);
            }

            // Close streams
            cipherInputStream.close();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}