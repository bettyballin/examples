import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PublicKey;
import java.security.spec.RSAPrivateCrtKeySpec;
import java.security.spec.RSAPublicKeySpec;

public class Main {
    public static void main(String[] args) {
        try {
            // Generate a key pair
            KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
            kpg.initialize(2048);
            KeyPair kp = kpg.genKeyPair();

            // Get the private key spec
            KeyFactory fact = KeyFactory.getInstance("RSA");
            RSAPrivateCrtKeySpec privSpec = fact.getKeySpec(kp.getPrivate(), RSAPrivateCrtKeySpec.class);

            // Set your desired public exponent value
            BigInteger eValue = BigInteger.valueOf(17); // Example: 17

            // Create a new instance of RSAPublicKeySpec with the modulus and custom 'e' values
            RSAPublicKeySpec pubSpecCustomE = new RSAPublicKeySpec(privSpec.getModulus(), eValue);

            // Generate the public key with the custom 'e' value
            PublicKey publicKeyWithCustomE = fact.generatePublic(pubSpecCustomE);

            // Print the public key
            System.out.println(publicKeyWithCustomE.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}