import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidKeyException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;

public class Temp1689 {
    public static void main(String[] args) {
        try {
            String dataToEncrypt = "This is some data to encrypt";
            SecretKey key = KeyGenerator.getInstance("AES").generateKey();
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] encryptedData = cipher.doFinal(dataToEncrypt.getBytes());
            
            // Print the encrypted data in hexadecimal format
            StringBuilder sb = new StringBuilder();
            for (byte b : encryptedData) {
                sb.append(String.format("%02X ", b));
            }
            System.out.println("Encrypted Data: " + sb.toString());

        } catch (NoSuchAlgorithmException | InvalidKeyException | BadPaddingException | IllegalBlockSizeException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}