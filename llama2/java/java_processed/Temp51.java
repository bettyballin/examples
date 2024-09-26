import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SecureRandom;

public class Temp51 {
    public static void main(String[] args) {
        try {
            // Create a key pair for signing and verification
            KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
            kpg.initialize(2048, new SecureRandom());
            KeyPair kp = kpg.generateKeyPair();
            PrivateKey privateKey = kp.getPrivate();
            PublicKey publicKey = kp.getPublic();

            // Sign the file using the private key
            String data = "This is some data to sign";
            Signature signature = Signature.getInstance("SHA256withRSA");
            signature.initSign(privateKey);
            signature.update(data.getBytes());
            byte[] signedData = signature.sign();

            // Verify the signature using the public key
            signature.initVerify(publicKey);
            signature.update(data.getBytes());
            boolean isVerified = signature.verify(signedData);

            System.out.println("Signature verified: " + isVerified);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}