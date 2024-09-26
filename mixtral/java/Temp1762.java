import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;

public class Temp1762 {
    public static void main(String[] args) {
        // Example usage (you need to provide a valid private key and encrypted text)
        // PrivateKey privateKey = ...;
        // String encryptedText = "...";
        // try {
        //     byte[] decryptedData = decrypt(encryptedText, privateKey);
        //     System.out.println(new String(decryptedData));
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }
    }

    public static byte[] decrypt(String text, PrivateKey privateKey) throws NoSuchAlgorithmException,
            NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {

        Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPPadding");

        // Initialize the cipher with decryption mode and private key
        cipher.init(Cipher.DECRYPT_MODE, privateKey);

        byte[] encryptedBytes = Base64.getDecoder().decode(text);

        return cipher.doFinal(encryptedBytes);
    }
}