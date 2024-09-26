import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.NoSuchAlgorithmException;

public class Temp2149 {
    public static void main(String[] args) {
        try {
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
            keyGen.initialize(4096);
            KeyPair pair = keyGen.generateKeyPair();
            PrivateKey privateKey = pair.getPrivate();
            PublicKey publicKey = pair.getPublic();
            
            // Just to avoid any unused variable warnings
            System.out.println("Private Key: " + privateKey);
            System.out.println("Public Key: " + publicKey);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}