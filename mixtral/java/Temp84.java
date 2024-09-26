import java.security.*;
import java.util.Base64;

public class Temp84 {
    public static void main(String[] args) {
        try {
            // Generate a key pair
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("DSA");
            keyGen.initialize(1024, new SecureRandom());
            KeyPair pair = keyGen.generateKeyPair();
            PublicKey pub = pair.getPublic();
            PrivateKey priv = pair.getPrivate();

            // Encode public key
            byte[] publicKeyArray = pub.getEncoded();
            String publicKey = Base64.getEncoder().encodeToString(publicKeyArray);

            System.out.println("Public key is " + publicKey);

            // Create a signature
            Signature dsa = Signature.getInstance("SHA1withDSA");
            dsa.initSign(priv);

            // Supply data to be signed
            String data = "This is some data to be signed";
            dsa.update(data.getBytes());

            // Generate a signature
            byte[] signature = dsa.sign();
            String signatureValue = Base64.getEncoder().encodeToString(signature);

            System.out.println("Signature value is " + signatureValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}