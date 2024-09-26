import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.RSAPublicKeySpec;
import java.util.Base64;

public class Temp2328 {
    public static void main(String[] args) {
        try {
            String modulusAsString = "your_modulus_base64_string_here";
            String exponentAsString = "your_exponent_base64_string_here";
            
            BigInteger modulus = new BigInteger(1, Base64.getDecoder().decode(modulusAsString));
            BigInteger exponent = new BigInteger(1, Base64.getDecoder().decode(exponentAsString));

            RSAPublicKeySpec keySpec = new RSAPublicKeySpec(modulus, exponent);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PublicKey pubKey = keyFactory.generatePublic(keySpec);

            System.out.println("Public Key: " + pubKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}