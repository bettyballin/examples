import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.io.ByteArrayInputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.security.SecureRandom;

public class Temp996 {
    public static void main(String[] args) throws Exception {
        // Generate secret key
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(256);
        SecretKey secretKey = keyGen.generateKey();

        // Encrypt
        IvParameterSpec iv = new IvParameterSpec(generateRandomIV());
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);

        // Decrypt
        byte[] ctBytes = readFromFile(); // Read the stored IV and ciphertext from file
        ByteArrayInputStream is = new ByteArrayInputStream(ctBytes);
        ObjectInput input = new ObjectInputStream(is);

        IvParameterSpec ivSpec = (IvParameterSpec) input.readObject();
        cipher.init(Cipher.DECRYPT_MODE, secretKey, ivSpec);
    }

    private static byte[] generateRandomIV() {
        byte[] iv = new byte[16];
        SecureRandom random = new SecureRandom();
        random.nextBytes(iv);
        return iv;
    }

    private static byte[] readFromFile() {
        // This method should be implemented to read the IV and ciphertext from a file.
        // For now, it returns a dummy byte array for illustration purposes.
        return new byte[16];
    }
}