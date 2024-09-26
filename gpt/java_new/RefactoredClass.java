import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.spec.SecretKeySpec;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class RefactoredClass {
    private Cipher aesCipher;
    private SecretKeySpec aeskeySpec;

    public boolean sessionKeyVer(File file) throws Exception {
        aesCipher.init(Cipher.DECRYPT_MODE, aeskeySpec); // switching mode for decryption

        try (CipherInputStream is = new CipherInputStream(new FileInputStream(file), aesCipher);
             ByteArrayOutputStream os = new ByteArrayOutputStream()) {

            byte[] b = new byte[1024];
            int i;
            while ((i = is.read(b)) != -1) {
                os.write(b, 0, i);
            }

            String file_string = os.toString(StandardCharsets.UTF_8.name());
            // Do something with file_string
            // ...

            return true; // Assuming verification is successful
        } catch (IOException e) {
            e.printStackTrace();
            return false; // In case of I/O errors
        }
    }
}