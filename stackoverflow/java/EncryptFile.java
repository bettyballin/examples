import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;

public class EncryptFile {
    public static void encryptFile(String inputFile, String outputFile, Cipher cipher) throws IOException {
        try (
            FileInputStream inputStream = new FileInputStream(inputFile);
            FileOutputStream fileOut = new FileOutputStream(outputFile);
            CipherOutputStream out = new CipherOutputStream(fileOut, cipher)
        ) {
            byte[] buffer = new byte[8192];
            int count;
            while ((count = inputStream.read(buffer)) > 0) {
                out.write(buffer, 0, count);
            }
        }
    }
}