import javax.crypto.Cipher;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

public class Temp1069 {
    public static void main(String[] args) {
        try {
            // Replace with your private key in Base64 format
            String privateKeyBase64 = "YOUR_PRIVATE_KEY_IN_BASE64";
            
            // Decode Base64 to get the byte array of the private key
            byte[] privateKeyBytes = Base64.getDecoder().decode(privateKeyBase64);

            // Generate the private key from the byte array
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PrivateKey privateKey = keyFactory.generatePrivate(keySpec);

            // Initialize the cipher
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);

            // Replace with your encrypted bytes in Base64 format
            String encryptedBytesBase64 = "YOUR_ENCRYPTED_BYTES_IN_BASE64";
            byte[] encryptedBytes = Base64.getDecoder().decode(encryptedBytesBase64);

            // Decrypt the bytes
            byte[] plainText = cipher.doFinal(encryptedBytes);

            // Print the decrypted text
            System.out.println(new String(plainText));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}