import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws Exception {
        String FileName1 = "encryptedfile"; // Replace with your actual file name

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("secretkeyfile"))) {
            SecretKey SecKey = (SecretKey) ois.readObject();

            Cipher AesCipher = Cipher.getInstance("AES");

            byte[] cipherText = Files.readAllBytes(Paths.get(FileName1));

            // Add any further processing here if needed
        }
    }
}