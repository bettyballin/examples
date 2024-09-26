import javax.crypto.Cipher;
import javax.crypto.EncryptedPrivateKeyInfo;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.spec.KeySpec;

public class CryptoUtils5 {

    public static byte[] decryptPrivateKey(byte[] key) throws Exception {
        KeySpec passKeySpec = new PBEKeySpec("password".toCharArray()); // Replace with your password
        EncryptedPrivateKeyInfo encryptedKey = new EncryptedPrivateKeyInfo(key);

        // Extract the encryption algorithm name
        String algName = encryptedKey.getAlgName();

        // Create a SecretKeyFactory
        SecretKeyFactory keyFac = SecretKeyFactory.getInstance(algName);
        
        // Generate a SecretKey
        SecretKey pbeKey = keyFac.generateSecret(passKeySpec);
        
        // Create and initialize a Cipher
        Cipher pbeCipher = Cipher.getInstance(algName);
        pbeCipher.init(Cipher.DECRYPT_MODE, pbeKey, encryptedKey.getAlgParameters());

        // Decrypt the private key
        return pbeCipher.doFinal(encryptedKey.getEncryptedData());
    }
    
    // Usage example
    public static void main(String[] args) {
        try {
            byte[] encryptedKey = {/*...*/}; // replace with actual encrypted key bytes
            byte[] decryptedKey = decryptPrivateKey(encryptedKey);
            // Use the decrypted private key
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}