import javax.crypto.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;

public class FileEncryption {
    public static void main(String[] args) throws Exception {
        Path file = Paths.get("input.txt"); // path to your input file
        Path encryptedFile = Paths.get("encrypted.dat"); // path to your output encrypted file
        Path decryptedFile = Paths.get("decrypted.txt"); // path to your output decrypted file

        byte[] plaintextBytes = Files.readAllBytes(file);

        Cipher cipher = Cipher.getInstance("AES");

        SecretKey secretKey = generateSecretKey();

        // Encryption
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        byte[] encryptedBytes = cipher.doFinal(plaintextBytes);

        Files.write(encryptedFile, encryptedBytes);

        // Decryption
        byte[] encryptedDataFromFile = Files.readAllBytes(encryptedFile);

        Cipher decCipher = Cipher.getInstance("AES");

        // Use the same secret key for decryption
        decCipher.init(Cipher.DECRYPT_MODE, secretKey);

        byte[] plaintextBytesFromFile = decCipher.doFinal(encryptedDataFromFile);

        Files.write(decryptedFile, plaintextBytesFromFile);
    }

    private static SecretKey generateSecretKey() throws NoSuchAlgorithmException {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128); // for example, 128-bit AES key
        return keyGen.generateKey();
    }
}