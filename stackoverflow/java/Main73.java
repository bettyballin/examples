import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.RSAPrivateKeySpec;

public class Main73 {
    public static RSAPrivateKey getPrivateKey(BigInteger modulus, BigInteger exponent) throws Exception {
        RSAPrivateKeySpec rsaPrivateKeySpec = new RSAPrivateKeySpec(modulus, exponent);
        KeyFactory fact = KeyFactory.getInstance("RSA");
        RSAPrivateKey privateKey = (RSAPrivateKey) fact.generatePrivate(rsaPrivateKeySpec);
        
        return privateKey;
    }
    
    public static void main(String[] args) {
        // Example usage
        BigInteger modulus = new BigInteger("..."); // replace with actual modulus
        BigInteger exponent = new BigInteger("..."); // replace with actual exponent
        
        try {
            RSAPrivateKey privateKey = getPrivateKey(modulus, exponent);
            // Use the private key as needed
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}