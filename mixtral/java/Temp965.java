import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.SecretKeySpec;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;

public class Temp965 {
    public static void main(String[] args) throws GeneralSecurityException, IOException {
        String key = "yourkeyhere"; // Replace with your actual key
        byte[] j = key.getBytes();
        SecretKeySpec kye = new SecretKeySpec(j, "AES");
        Cipher enc = Cipher.getInstance("AES");
        enc.init(Cipher.ENCRYPT_MODE, kye);

        try (FileInputStream file = new FileInputStream("inputfile.mkv")) {
            try (FileOutputStream output = new FileOutputStream("xyz.mkv")) {
                CipherOutputStream cos = new CipherOutputStream(output, enc);

                byte[] buf = new byte[4096];
                int read;

                while ((read = file.read(buf)) != -1) {
                    cos.write(buf, 0, read);
                }

                // Flush and close the CipherOutputStream
                cos.flush();
                cos.close();
            }
        }
    }
}