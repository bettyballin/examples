import javax.crypto.Cipher;
import java.security.PrivateKey;

public class RefactoredSnippet3 {
    public void decryptData(byte[] encryptedData, PrivateKey privateKey) {
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] signature = cipher.doFinal(encryptedData);
            // further processing if needed
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            // Handle the exception or rethrow
        }
    }
}