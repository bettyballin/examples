import javax.crypto.*;
import java.security.*;
import java.util.Base64;

public class Temp1020 {
    public static void main(String[] args) {
        String plainText = "Hello, World!";
        String encryptedText = encrypt(plainText);
        System.out.println("Encrypted Text: " + encryptedText);
    }

    public static String encrypt(String plainText) {
        try {
            KeyGenerator desKeyGen = KeyGenerator.getInstance("DES");
            SecretKey myDesKey = desKeyGen.generateKey();

            Cipher desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");

            // Convert the key to Base64 encoded string
            String base64EncodedSecretKey = Base64.getEncoder().encodeToString(myDesKey.getEncoded());

            desCipher.init(Cipher.ENCRYPT_MODE, myDesKey);

            byte[] textEncrypted = desCipher.doFinal(plainText.getBytes());
            return Base64.getEncoder().encodeToString(textEncrypted);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}