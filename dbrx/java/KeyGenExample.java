import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.SecureRandom;

public class KeyGenExample {
    public static void main(String[] args) throws Exception {
        // Create a key generator for DESede (3DES)
        KeyGenerator kgen = KeyGenerator.getInstance("DESede");

        // Initialize the random number source used to generate keys
        SecureRandom rng = new SecureRandom();

        // Initialize the key generator with the random number source
        kgen.init(168, rng); // 168 bits for DESede

        // Generate the secret key
        SecretKey skey = kgen.generateKey();

        System.out.println(skey.getAlgorithm());
    }
}