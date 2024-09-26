import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;

public class Gen_DESAES_key {

    public static void main(String[] args) {
        try {
            byte[] message = "Hello World".getBytes("UTF-8");

            KeyGenerator keygenerator = KeyGenerator.getInstance("DES");
            SecretKey desKey = keygenerator.generateKey();

            Cipher desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            desCipher.init(Cipher.ENCRYPT_MODE, desKey);

            byte[] encryptedMessage = desCipher.doFinal(message);
            String base64EncryptedMessage = Base64.getEncoder().encodeToString(encryptedMessage);

            System.out.println("Encrypted Message: " + base64EncryptedMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}