import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;

public class Temp792 {
    public static void main(String[] args) {
        try {
            // Generate DH key pair
            DHParameterSpec dhSpec = new DHParameterSpec(BigInteger.valueOf(23), BigInteger.valueOf(5));
            KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("DH");
            keyPairGen.initialize(dhSpec);
            KeyPair dkp = keyPairGen.generateKeyPair();
            
            // Get private and public keys
            BigInteger x = ((DHPrivateKey) dkp.getPrivate()).getX();
            BigInteger y = ((DHPublicKey) dkp.getPublic()).getY();
            
            // Print the values of x and y
            System.out.println("Private key value (x): " + x);
            System.out.println("Public key value (y): " + y);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
    }
}