import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class Temp1812 {
    private static final String inputFile = "input.txt"; // Example input file path
    private static final String outputFile = "output.txt"; // Example output file path

    public static void main(String[] args) {
        try {
            // Generating a secret key for encryption
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(256); // for example, 256-bit AES key
            SecretKey secretKey = keyGen.generateKey();

            // Creating a Cipher instance with AES encryption
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            FileInputStream inputStream = new FileInputStream(inputFile);
            FileOutputStream fileout = new FileOutputStream(outputFile);
            CipherOutputStream out = new CipherOutputStream(fileout, cipher);

            try {
                byte[] buffer = new byte[8192];
                int count;
                while ((count = inputStream.read(buffer)) > 0) {
                    out.write(buffer, 0, count);
                }
            } finally {
                out.close();
                inputStream.close();
            }
        } catch (NoSuchAlgorithmException | InvalidKeyException | IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}