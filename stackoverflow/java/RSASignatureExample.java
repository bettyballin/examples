// This Java code snippet doesn't correspond directly to the PHP code above, as PHP and Java are different languages with different libraries.
// However, here's a similar Java code snippet that achieves RSA signing with a SHA256 digest.

import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.Base64;

public class RSASignatureExample {

    public static void main(String[] args) {

        String data = "For my current project I have to send a signature from PHP to Java application. I am using Crypt/RSA right now for signing my data.";
        String privateKeyPEM = "-----BEGIN RSA PRIVATE KEY-----
" +
                // Paste your private key string here, removing the first and last lines
                "-----END RSA PRIVATE KEY-----";

        try {
            // Convert PEM format to a PrivateKey instance
            PrivateKey privateKey = getPrivateKeyFromPEM(privateKeyPEM);
            // Sign the data
            byte[] signature = signData(data.getBytes(StandardCharsets.UTF_8), privateKey);
            // Print the base64 encoded signature
            System.out.println(Base64.getEncoder().encodeToString(signature));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static byte[] signData(byte[] data, PrivateKey privateKey) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        Signature signer = Signature.getInstance("SHA256withRSA");
        signer.initSign(privateKey);
        signer.update(data);
        return signer.sign();
    }

    private static PrivateKey getPrivateKeyFromPEM(String privateKeyPEM) throws GeneralSecurityException {
        // Implementation to convert PEM format to PrivateKey instance goes here
        // This often involves stripping the header/footer and using KeyFactory with PKCS8EncodedKeySpec
        // This code is not complete and serves as a placeholder for the actual implementation
        return null;
    }
}