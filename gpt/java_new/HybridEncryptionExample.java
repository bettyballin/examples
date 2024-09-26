import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;

public class HybridEncryptionExample {

    public static void main(String[] args) throws Exception {
        // Step 1: Generate RSA key pair
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        // Step 2: Generate AES key
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(256);
        SecretKey secretKey = keyGenerator.generateKey();

        // Step 3: Encrypt AES key with RSA public key
        Cipher rsaCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        rsaCipher.init(Cipher.ENCRYPT_MODE, keyPair.getPublic());
        byte[] encryptedSecretKey = rsaCipher.doFinal(secretKey.getEncoded());

        // Step 4: Encrypt data using AES key
        Cipher aesCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        byte[] iv = new byte[16];
        new SecureRandom().nextBytes(iv);
        IvParameterSpec ivSpec = new IvParameterSpec(iv);
        aesCipher.init(Cipher.ENCRYPT_MODE, secretKey, ivSpec);
        byte[] data = "Hello, World!".getBytes("UTF-8");
        byte[] encryptedData = aesCipher.doFinal(data);

        // Step 5: Decrypt AES key with RSA private key
        rsaCipher.init(Cipher.DECRYPT_MODE, keyPair.getPrivate());
        byte[] decryptedSecretKey = rsaCipher.doFinal(encryptedSecretKey);

        // Step 6: Decrypt data using decrypted AES key
        SecretKey originalSecretKey = new javax.crypto.spec.SecretKeySpec(decryptedSecretKey, "AES");
        aesCipher.init(Cipher.DECRYPT_MODE, originalSecretKey, ivSpec);
        byte[] decryptedData = aesCipher.doFinal(encryptedData);

        // Output the original data
        System.out.println(new String(decryptedData, "UTF-8"));
    }
}