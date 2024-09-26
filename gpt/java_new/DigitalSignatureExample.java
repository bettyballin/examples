import java.security.*;
import java.util.Base64;

public class DigitalSignatureExample {
    public static void main(String[] args) {
        try {
            // Generate a key pair
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("DSA");
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            keyGen.initialize(1024, random);
            KeyPair pair = keyGen.generateKeyPair();
            PrivateKey priv = pair.getPrivate();
            PublicKey pub = pair.getPublic();

            // Create a Signature object and initialize it with the private key
            Signature dsa = Signature.getInstance("SHA1withDSA");
            dsa.initSign(priv);

            String str = "This is a string to sign";
            byte[] strByte = str.getBytes("UTF-8");
            dsa.update(strByte);

            // Generate a signature for the data
            byte[] realSig = dsa.sign();
            System.out.println("Signature: " + Base64.getEncoder().encodeToString(realSig));

            // Verify the signature with the public key
            dsa.initVerify(pub);
            dsa.update(strByte);
            boolean verifies = dsa.verify(realSig);
            System.out.println("Signature verifies: " + verifies);
        } catch (NoSuchAlgorithmException | InvalidKeyException | SignatureException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}