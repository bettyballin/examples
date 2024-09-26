import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws Exception {
        String fileName = "your_filename_here"; // Replace with your actual file name

        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128); // for example
        SecretKey secKey = keyGen.generateKey();

        Cipher aesCipher = Cipher.getInstance("AES");

        byte[] cipherText = Files.readAllBytes(Paths.get(fileName));

        aesCipher.init(Cipher.ENCRYPT_MODE, secKey);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("secretkeyfile"))) {
            oos.writeObject(secKey);
        }
    }
}