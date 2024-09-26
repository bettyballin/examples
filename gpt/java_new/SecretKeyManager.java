import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SecretKeyManager {

    public static void main(String[] args) throws Exception {
        SecretKey secKey = null; // Initialize variable

        // Save the secret key to a file
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:/ashok/SecKeyFile"))) {
            oos.writeObject(secKey);
        }

        // Load the secret key from a file
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:/ashok/SecKeyFile"))) {
            secKey = (SecretKey) ois.readObject();
        }

        Cipher aesCipher = Cipher.getInstance("AES");
        // Rest of your code
    }
}