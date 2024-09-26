import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.Cipher;

public class RSAEncryption {
    public static void main(String[] args) throws Exception {
        // Generate a key pair
        KeyPairGenerator kg = KeyPairGenerator.getInstance("RSA");
        kg.initialize(2048, new SecureRandom());
        KeyPair kp = kg.generateKeyPair();
        PublicKey publicKey = kp.getPublic();
        PrivateKey privateKey = kp.getPrivate();

        // Encrypt the symmetric key using RSA
        String symmetricKey = "MySymmetricKey";
        byte[] symmetricKeyBytes = symmetricKey.getBytes("UTF-8");

        Cipher rsaCipher = Cipher.getInstance("RSA");
        rsaCipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encryptedSymmetricKey = rsaCipher.doFinal(symmetricKeyBytes);

        // Print out the encrypted symmetric key in Base64
        String encryptedSymmetricKeyBase64 = Base64.getEncoder().encodeToString(encryptedSymmetricKey);
        System.out.println("Encrypted Symmetric Key: " + encryptedSymmetricKeyBase64);

        // Decrypt the symmetric key using RSA
        rsaCipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedSymmetricKeyBytes = rsaCipher.doFinal(encryptedSymmetricKey);
        String decryptedSymmetricKey = new String(decryptedSymmetricKeyBytes, "UTF-8");

        // Print out the decrypted symmetric key
        System.out.println("Decrypted Symmetric Key: " + decryptedSymmetricKey);
    }
}