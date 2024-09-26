import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPublicKey;
import java.security.interfaces.RSAPrivateKey;

public class RSAClass {
    public static void main(String[] args) {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048);
            KeyPair keypair = keyPairGenerator.generateKeyPair();

            RSAPublicKey rsaPublicKey = (RSAPublicKey) keypair.getPublic();
            RSAPrivateKey rsaPrivateKey = (RSAPrivateKey) keypair.getPrivate();
            
            // Your code to use rsaPublicKey and rsaPrivateKey goes here
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}