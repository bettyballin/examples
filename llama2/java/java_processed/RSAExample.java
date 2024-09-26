import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import javax.crypto.Cipher;

public class RSAExample {
    public static void main(String[] args) throws Exception {
        // Private key in PEM format
        String pemPrivateKey = "-----BEGIN PRIVATE KEY-----\n" +
                "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQD3q6vJ1y31cK29\n" +
                "......\n" +
                "-----END PRIVATE KEY-----";

        // Public key in PEM format
        String pemPublicKey = "-----BEGIN PUBLIC KEY-----\n" +
                "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAt6jQyK4Y8IvZ4E6Fz6j8\n" +
                "......\n" +
                "-----END PUBLIC KEY-----";

        // Remove the first and last lines
        String privateKeyPEM = pemPrivateKey.replace("-----BEGIN PRIVATE KEY-----", "")
                                            .replace("-----END PRIVATE KEY-----", "")
                                            .replaceAll("\\s+","");

        String publicKeyPEM = pemPublicKey.replace("-----BEGIN PUBLIC KEY-----", "")
                                          .replace("-----END PUBLIC KEY-----", "")
                                          .replaceAll("\\s+","");

        // Decode Base64
        byte[] decodedPrivateKey = Base64.getMimeDecoder().decode(privateKeyPEM);
        byte[] decodedPublicKey = Base64.getMimeDecoder().decode(publicKeyPEM);

        // Make a KeyFactory
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");

        // Create private key
        PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(decodedPrivateKey);
        PrivateKey privateKey = keyFactory.generatePrivate(privateKeySpec);

        // Create public key
        X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(decodedPublicKey);
        PublicKey publicKey = keyFactory.generatePublic(publicKeySpec);

        // Print keys to verify
        System.out.println("Private Key: " + Base64.getMimeEncoder().encodeToString(privateKey.getEncoded()));
        System.out.println("Public Key: " + Base64.getMimeEncoder().encodeToString(publicKey.getEncoded()));

        // Encrypt a message with the public key
        String message = "Hello, World!";
        Cipher encryptCipher = Cipher.getInstance("RSA");
        encryptCipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encryptedMessage = encryptCipher.doFinal(message.getBytes());
        System.out.println("Encrypted Message: " + Base64.getMimeEncoder().encodeToString(encryptedMessage));

        // Decrypt the message with the private key
        Cipher decryptCipher = Cipher.getInstance("RSA");
        decryptCipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedMessage = decryptCipher.doFinal(encryptedMessage);
        System.out.println("Decrypted Message: " + new String(decryptedMessage));
    }
}