import com.auth0.jwt.algorithms.Algorithm;
import java.security.interfaces.RSAPublicKey;
import java.security.interfaces.RSAPrivateKey;

public class Temp1460 {
    public static void main(String[] args) {
        // Dummy keys for demonstration; replace with actual keys
        RSAPublicKey publicKey = null;
        RSAPrivateKey privateKey = null;

        Algorithm algorithmRS = Algorithm.RSA256(publicKey, privateKey);
        // Now you can use this 'algorithmRS' to sign and verify JWTs
    }
}