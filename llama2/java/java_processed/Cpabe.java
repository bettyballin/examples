import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class Cpabe {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        String plaintext = "Hello World!";
        String ciphertext = encrypt(plaintext);
        System.out.println("Encrypted text: " + ciphertext);

        byte[] decoded = Base64.getDecoder().decode(ciphertext);
        String decodedString = new String(decoded);
        System.out.println("Decoded text: " + decodedString);
    }

    public static String encrypt(String plaintext) throws IOException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        byte[] plaintextBytes = plaintext.getBytes();
        ByteArrayInputStream plaintextStream = new ByteArrayInputStream(plaintextBytes);

        SecretKey secretKey = generateSecretKey();
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        byte[] encryptedBytes = cipher.doFinal(plaintextBytes);
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public static SecretKey generateSecretKey() throws NoSuchAlgorithmException {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128);
        return keyGen.generateKey();
    }
}