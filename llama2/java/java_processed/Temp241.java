import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class Temp241 {
    private static final Logger LOGGER = Logger.getLogger(Temp241.class.getName());

    public static void main(String[] args) {
        try {
            // Example private key in PKCS8 format (Base64 encoded)
            String privateKeyPEM = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASC..."; // truncated for brevity

            // Convert the string to a PrivateKey object
            byte[] privateKeyBytes = Base64.getDecoder().decode(privateKeyPEM);
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PrivateKey privateKey = keyFactory.generatePrivate(keySpec);

            // Example document to sign
            byte[] BYdocument = "Example document".getBytes();

            // Create a Signature instance with the given algorithm
            Signature signature = Signature.getInstance("SHA512withRSA");

            // Initialize the signature with the private key
            signature.initSign(privateKey);

            // Update the signature with the document
            signature.update(BYdocument);

            // Get the signed byte array
            byte[] BYsignedDocument = signature.sign();

            // Generate public key from private key
            KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
            kpg.initialize(2048);
            KeyPair kp = kpg.generateKeyPair();
            PublicKey publicKey = kp.getPublic();

            // For demonstration, verify the signature using the same document and public key
            Signature verifier = Signature.getInstance("SHA512withRSA");
            verifier.initVerify(publicKey); // Using the public key
            verifier.update(BYdocument);
            boolean isValidSignature = verifier.verify(BYsignedDocument);

            if (isValidSignature) {
                LOGGER.log(Level.INFO, "The given byte array is indeed a valid RSA signature.");
            } else {
                LOGGER.log(Level.SEVERE, "The given byte array is not a valid RSA signature.");
            }
        } catch (NoSuchAlgorithmException | GeneralSecurityException e) {
            e.printStackTrace();
        }
    }
}