import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.SecretKey;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Temp76 {

    public static void main(String[] args) throws Exception {

        File encryptedFile = new File("path_to_your_encrypted_file"); // your file
        SecretKey secretKey = ... // your secret key
        Cipher c = Cipher.getInstance("AES"); // specify your algorithm

        // Decrypt data
        c.init(Cipher.DECRYPT_MODE, secretKey);
        FileInputStream inputStream = new FileInputStream(encryptedFile);
        CipherInputStream decryptionStream = new CipherInputStream(inputStream, c);

        byte[] outputBytes;
        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[1024];
            int read;

            while ((read = decryptionStream.read(buffer)) > 0)
                out.write(buffer, 0, read);

            outputBytes = out.toByteArray();
        }

        // Optionally, write the decrypted data to a file or process it as needed
        // For example:
        // FileOutputStream fos = new FileOutputStream("path_to_output_file");
        // fos.write(outputBytes);
        // fos.close();
    }
}