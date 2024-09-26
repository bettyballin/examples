import java.security.*;
import java.security.spec.*;

public class Temp490 {
    public static void main(String[] args) {
        try {
            ECGenParameterSpec ecParams = new ECGenParameterSpec("secp256r1");
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("EC");
            keyGen.initialize(ecParams);

            KeyPair keyPair = keyGen.generateKeyPair();
            PublicKey publicKey = keyPair.getPublic();
            PrivateKey privateKey = keyPair.getPrivate();

            System.out.println("Public Key: " + publicKey);
            System.out.println("Private Key: " + privateKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}