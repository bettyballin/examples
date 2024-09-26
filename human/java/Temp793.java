import javax.crypto.KeyPair;
import javax.crypto.KeyPairGenerator;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import java.math.BigInteger;

public class Temp793 {
    public static void main(String[] args) {
        try {
            // Generate a key pair using the DH algorithm
            KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("DH");
            keyPairGen.initialize(2048); // You can specify the key size
            KeyPair keyPair = keyPairGen.generateKeyPair();

            // Obtain DH parameters from the public key
            DHParameterSpec params = ((DHPublicKey) keyPair.getPublic()).getParams();
            BigInteger p = params.getP();
            BigInteger g = params.getG();

            // Print the DH parameters
            System.out.println("p: " + p);
            System.out.println("g: " + g);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}