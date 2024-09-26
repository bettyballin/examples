import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.zip.InflaterInputStream;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class Temp2315 {
    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IOException {
        byte[] data = "example data".getBytes(); // sample data
        byte[] key = "1234567890123456".getBytes(); // sample key, must meet the algorithm's key length requirements
        SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);

        InflaterInputStream inflaterInputStream = new InflaterInputStream(new CipherInputStream(new ByteArrayInputStream(data), cipher));
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = inflaterInputStream.read(buffer)) != -1) {
            System.out.write(buffer, 0, bytesRead);
        }
        inflaterInputStream.close();
    }
}