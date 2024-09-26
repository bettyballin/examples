import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.RSAPrivateKeySpec;
import java.security.interfaces.RSAPrivateKey;

public class Temp2225 {
    public static void main(String[] args) {
        try {
            // Example modulus and exponent (these should be replaced with actual values)
            BigInteger modulus = new BigInteger("00af795cf5a2c2...", 16);
            BigInteger exponent = new BigInteger("00e8d4a51000...", 16);

            // Get Private Key
            RSAPrivateKeySpec rsaPrivateKeySpec = new RSAPrivateKeySpec(modulus, exponent);
            KeyFactory fact = KeyFactory.getInstance("RSA");
            RSAPrivateKey privateKey = (RSAPrivateKey) fact.generatePrivate(rsaPrivateKeySpec);

            System.out.println(privateKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}