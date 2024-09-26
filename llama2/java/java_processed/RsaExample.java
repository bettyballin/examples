import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;

public class RsaExample {
    public static void main(String[] args) throws NoSuchAlgorithmException, SignatureException {
        // Generate a key pair
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);
        KeyPair keyPair = keyGen.generateKeyPair();
        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();

        try {
            // Create a signature object
            Signature signature = Signature.getInstance("SHA256withRSA");

            // Initialize the signature with the private key
            signature.initSign(privateKey);

            // Update the data to be signed
            String data = "This is a message to be signed";
            signature.update(data.getBytes());

            // Sign the data
            byte[] digitalSignature = signature.sign();

            System.out.println("Digital signature: " + bytesToHex(digitalSignature));

            // Verify the signature with the public key
            signature.initVerify(publicKey);
            signature.update(data.getBytes());
            boolean isVerified = signature.verify(digitalSignature);

            System.out.println("Signature verified: " + isVerified);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}