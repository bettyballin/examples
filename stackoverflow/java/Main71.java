import javax.crypto.Cipher;
import javax.crypto.SecretKey;

public class Main71 {
    public static void main(String[] args) {
        try {
            SecretKey desKey = null; // Assuming desKey is initialized elsewhere
            byte[] encryptedMessage = null; // Assuming encryptedMessage is initialized elsewhere
            Cipher desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");

            desCipher.init(Cipher.DECRYPT_MODE, desKey);
            byte[] decryptedMessage = desCipher.doFinal(encryptedMessage);

            System.out.println(new String(decryptedMessage));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}