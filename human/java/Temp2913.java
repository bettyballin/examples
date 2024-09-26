import java.nio.charset.StandardCharsets;
import java.security.*;

public class Temp2913 {
    public static void main(String[] args) {
        try {
            // Generate a key pair for demonstration purposes
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
            keyGen.initialize(2048);
            KeyPair keyPair = keyGen.generateKeyPair();
            PublicKey publicKey = keyPair.getPublic();
            PrivateKey privateKey = keyPair.getPrivate();

            // Original message
            String message = "signedMessage";

            // Create a Signature object and initialize it with the private key
            Signature signature = Signature.getInstance("SHA256withRSA");
            signature.initSign(privateKey);

            // Update and sign the data
            signature.update(message.getBytes(StandardCharsets.UTF_8));
            byte[] signatureBytes = signature.sign();

            // Now, verify the signature with the public key
            signature.initVerify(publicKey);
            signature.update(message.getBytes(StandardCharsets.UTF_8));
            boolean verified = signature.verify(signatureBytes);

            // Output the result
            System.out.println("Signature verified: " + verified);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}