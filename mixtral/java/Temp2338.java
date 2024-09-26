import javax.crypto.Cipher;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

public class Temp2338 {
    public static void main(String[] args) {
        try {
            // Generate RSA KeyPair
            KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
            kpg.initialize(4096);
            KeyPair keyPair = kpg.generateKeyPair();

            PublicKey publicKey = keyPair.getPublic();
            PrivateKey privateKey = keyPair.getPrivate();

            // Data to encrypt
            byte[] dataToEncrypt = "Hello, world!".getBytes();

            // Encrypt data with the local Public Key
            Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            byte[] encryptedData = cipher.doFinal(dataToEncrypt);

            // Decryption process (after recovering the local Public Key)
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] decryptedData = cipher.doFinal(encryptedData);

            // Display the decrypted data
            System.out.println(new String(decryptedData));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}