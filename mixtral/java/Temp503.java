import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.RSAPublicKeySpec;
import java.security.interfaces.RSAPublicKey;

public class Temp503 {
    public static void main(String[] args) throws Exception {

        // Generate RSA key pair with 2048-bit keys
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        kpg.initialize(2048);

        // Get the generated public and private keys
        KeyPair kp = kpg.genKeyPair();

        // Extract modulus public exponent from RSAPublicKeySpec
        RSAPublicKey pubKey = (RSAPublicKey) kp.getPublic();
        BigInteger n = pubKey.getModulus();

        // Set your desired value for the public exponent
        BigInteger e = new BigInteger("3"); // Example: set to 3

        // Create RSAPublicKeySpec with custom modulus and public exponent
        RSAPublicKeySpec rsaPubKeySpec = new RSAPublicKeySpec(n, e);

        // Generate the final RSA Public Key
        KeyFactory fact = KeyFactory.getInstance("RSA");
        PublicKey pubK = fact.generatePublic(rsaPubKeySpec);

        // Print the public key to verify
        System.out.println("Generated Public Key: " + pubK);
    }
}