import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.RSAPublicKeySpec;
import java.util.Base64;

public class RSAPublicKeyCreator {
    public static void main(String[] args) throws Exception {
        String modulusAsString = "..."; // Replace with your modulus
        String exponentAsString = "..."; // Replace with your exponent

        BigInteger modulus = new BigInteger(1, Base64.getDecoder().decode(modulusAsString));
        BigInteger exponent = new BigInteger(1, Base64.getDecoder().decode(exponentAsString));

        RSAPublicKeySpec keySpec = new RSAPublicKeySpec(modulus, exponent);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey pubKey = keyFactory.generatePublic(keySpec);
        
        // Use pubKey as needed
    }
}