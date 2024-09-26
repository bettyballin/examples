import java.math.BigInteger;
import java.security.AlgorithmParameterGenerator;
import java.security.AlgorithmParameters;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidParameterSpecException;
import javax.crypto.spec.DHParameterSpec;
import java.security.SecureRandom;

public class Main26 {
    public static void main(String[] args) {
        try {
            AlgorithmParameterGenerator paramGen = AlgorithmParameterGenerator.getInstance("DiffieHellman");
            paramGen.init(512, new SecureRandom());
            AlgorithmParameters params = paramGen.generateParameters();
            DHParameterSpec dhSpec = params.getParameterSpec(DHParameterSpec.class);

            BigInteger p = dhSpec.getP();
            BigInteger g = dhSpec.getG();
            
            // Use p and g as needed for Diffie-Hellman

        } catch (NoSuchAlgorithmException | InvalidParameterSpecException e) {
            e.printStackTrace();
        }
    }
}