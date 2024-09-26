import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Signature;
import java.util.logging.Logger;

public class SignatureExample1 {
    private static final Logger log = Logger.getLogger(SignatureExample1.class.getName());

    public static void main(String[] args) {
        try {
            // Generate a key pair
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
            keyGen.initialize(2048);
            KeyPair pair = keyGen.generateKeyPair();

            // Initialize a Signature object with the private key
            Signature sign = Signature.getInstance("SHA256withRSA");
            sign.initSign(pair.getPrivate());

            // Supply the data to be signed
            byte[] bytes = "Hello, World!".getBytes();
            sign.update(bytes);

            // Generate the signature
            byte[] signature = sign.sign();

            // Initialize the Signature object for verification with the public key
            Signature mySig2 = Signature.getInstance("SHA256withRSA");
            mySig2.initVerify(pair.getPublic());

            // Supply the Signature object with the data that was signed
            mySig2.update(bytes);

            // Verify the signature
            boolean isSigValid = mySig2.verify(signature);

            // Output the result of the signature verification
            log.info("Signature valid: " + isSigValid);
        } catch (Exception e) {
            log.severe("Error: " + e.getMessage());
        }
    }
}