import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.SecretKey;
import javax.crypto.KeyGenerator;
import java.util.Base64;
import java.security.SecureRandom;

public class Main {
    public static void main(String[] args) throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128); // initialize key size
        SecretKey secretKey = keyGen.generateKey();

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

        String data = "Hello World!";

        // Encryption
        SecureRandom random = new SecureRandom();
        byte[] ivBytes = new byte[cipher.getBlockSize()];
        random.nextBytes(ivBytes); // initialize ivBytes with random values
        IvParameterSpec ivSpec = new IvParameterSpec(ivBytes);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivSpec);

        byte[] encryptedData = cipher.doFinal(data.getBytes());

        System.out.println("Encrypted Data: " + Base64.getEncoder().encodeToString(encryptedData));

        // Decryption
        cipher.init(Cipher.DECRYPT_MODE, secretKey, ivSpec);
        byte[] decryptedData = cipher.doFinal(encryptedData); // remove base64 decoding

        String decryptedString = new String(decryptedData);

        System.out.println("Decrypted Data: " + decryptedString);
    }
}