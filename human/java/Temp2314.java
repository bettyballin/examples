import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.DeflaterInputStream;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.NoSuchPaddingException;
import java.security.NoSuchAlgorithmException;

public class Temp2314 {
    public static void main(String[] args) {
        byte[] data = "Sample data".getBytes();

        try {
            Cipher cipher = Cipher.getInstance("AES");
            InputStream inputStream = new CipherInputStream(
                new DeflaterInputStream(new ByteArrayInputStream(data)), 
                cipher
            );

            // Reading and printing the processed data (for demonstration purposes)
            int byteRead;
            while ((byteRead = inputStream.read()) != -1) {
                System.out.print((char) byteRead);
            }
            inputStream.close();
        } catch (NoSuchPaddingException | NoSuchAlgorithmException | IOException e) {
            e.printStackTrace();
        }
    }
}