import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

public class Rsa {
    public static void main(String[] args) {
        try {
            // RSA init
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
            keyGen.initialize(512);
            KeyPair keyPair = keyGen.generateKeyPair();
            PrivateKey privateKey = keyPair.getPrivate();
            PublicKey publicKey = keyPair.getPublic();

            // AES init
            KeyGenerator keyGen2 = KeyGenerator.getInstance("AES");
            keyGen2.init(128); // AES key size
            SecretKey secretKey = keyGen2.generateKey();

            String plaintext = "Hello World"; // Example plaintext

            // Encrypt with RSA public key
            Cipher rsaCipher = Cipher.getInstance("RSA");
            rsaCipher.init(Cipher.ENCRYPT_MODE, publicKey);
            byte[] encryptedBytes = rsaCipher.doFinal(plaintext.getBytes());

            // Decrypt with RSA private key
            rsaCipher.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] decryptedBytes = rsaCipher.doFinal(encryptedBytes);
            String decryptedString = new String(decryptedBytes);

            System.out.println("Original: " + plaintext);
            System.out.println("Encrypted: " + javax.xml.bind.DatatypeConverter.printHexBinary(encryptedBytes));
            System.out.println("Decrypted: " + decryptedString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}