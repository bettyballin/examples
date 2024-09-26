import java.security.*;
import java.util.logging.Logger;

public class Temp1890 {
    private static final Logger log = Logger.getLogger(Temp1890.class.getName());

    public static void main(String[] args) {
        try {
            // Generate a key pair for demonstration purposes
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("DSA");
            keyGen.initialize(1024);
            KeyPair keyPair = keyGen.generateKeyPair();
            PrivateKey privateKey = keyPair.getPrivate();
            PublicKey publicKey = keyPair.getPublic();

            // Create a signature object and initialize it with the private key
            Signature mySig = Signature.getInstance("SHA1withDSA");
            mySig.initSign(privateKey);

            // Data to be signed
            byte[] bytes = "This is a test message".getBytes("UTF8");
            mySig.update(bytes);

            // Sign the data
            byte[] signature = mySig.sign();

            // Create another signature object for verification and initialize it with the public key
            Signature mySig2 = Signature.getInstance("SHA1withDSA");
            mySig2.initVerify(publicKey);

            // Adding original message for verification
            mySig2.update(bytes);

            // Verify the signature
            boolean isSigValid = mySig2.verify(signature);

            // Log the result
            log.info("Valid Signing = " + isSigValid);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}