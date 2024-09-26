import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.ECPublicKey;

public class Temp1694 {

    public static void main(String[] args) {
        try {
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("EC");
            keyGen.initialize(256); // You can choose the key size
            KeyPair keyPair = keyGen.generateKeyPair();

            ECPublicKey ecPublic = (ECPublicKey) keyPair.getPublic();
            System.out.println("Public key: " + ecPublic);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}