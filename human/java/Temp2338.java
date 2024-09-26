import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

public class Temp2338 {
    public static void main(String[] args) {
        try {
            KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
            keyPairGen.initialize(2048);
            KeyPair keypair = keyPairGen.generateKeyPair();

            RSAPublicKey rsaPublicKey = (RSAPublicKey) keypair.getPublic();
            RSAPrivateKey rsaPrivateKey = (RSAPrivateKey) keypair.getPrivate();

            System.out.println("Public Key: " + rsaPublicKey);
            System.out.println("Private Key: " + rsaPrivateKey);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}