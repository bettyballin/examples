import javax.crypto.*;
import java.util.Base64;

public class Gen_DESKey {
    public static void main(String[] args) throws Exception {
        String message = "Hello World";

        KeyGenerator keygenerator = KeyGenerator.getInstance("DES");
        SecretKey desKey = keygenerator.generateKey();

        Cipher desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");

        // Encryption
        desCipher.init(Cipher.ENCRYPT_MODE, desKey);
        byte[] encryptedMessage = desCipher.doFinal(message.getBytes());

        // Print encrypted message in Base64 encoding
        System.out.println("Encrypted message: " + Base64.getEncoder().encodeToString(encryptedMessage));
    }
}