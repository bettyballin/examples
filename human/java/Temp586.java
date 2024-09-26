import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Base64;

public class Temp586 {
    private static final String ALGORITHM = "AES";
    private static final int ITERATIONS = 1000;

    public static void main(String[] args) {
        String message = "Hello, World!";
        String salt = "RandomSalt";
        String encryptedMessage = encryptMessage(message, salt);
        System.out.println("Encrypted Message: " + encryptedMessage);
    }

    public static String encryptMessage(String message, String salt) {
        String encMessage = message;
        byte[] encVal = null;
        String messageWithSalt = null;
        try {
            Key key = generateKey();

            Cipher c = Cipher.getInstance(ALGORITHM);
            c.init(Cipher.ENCRYPT_MODE, key);

            for (int i = 0; i < ITERATIONS; i++) {
                messageWithSalt = salt + encMessage;
                encVal = c.doFinal(messageWithSalt.getBytes());
                byte[] encryptedValue = Base64.getEncoder().encode(encVal);
                encMessage = new String(encryptedValue);
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
        return encMessage;
    }

    private static Key generateKey() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance(ALGORITHM);
        keyGen.init(128); // for example, 128-bit AES
        SecretKey secretKey = keyGen.generateKey();
        return secretKey;
    }
}