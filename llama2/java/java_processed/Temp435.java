import java.security.*;
import java.security.spec.*;
import java.util.Base64;

public class Temp435 {
    public static void main(String[] args) {
        try {
            // Generate ECDSA key pair
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("EC");
            keyGen.initialize(new ECGenParameterSpec("secp256r1"));
            KeyPair keyPair = keyGen.generateKeyPair();

            // Create and initialize the signature object
            Signature ecdsaSign = Signature.getInstance("SHA256withECDSA");
            ecdsaSign.initSign(keyPair.getPrivate());

            // Sample data to sign
            String data = "Sample data to be signed";
            ecdsaSign.update(data.getBytes());

            // Generate the signature
            byte[] signature = ecdsaSign.sign();

            System.out.println("Signature: " + Base64.getEncoder().encodeToString(signature));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}