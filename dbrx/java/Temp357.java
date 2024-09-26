import java.security.*;
import java.security.spec.*;

public class Temp357 {
    public static void main(String[] args) {
        try {
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("EC");
            ECGenParameterSpec ecSpec = new ECGenParameterSpec("secp192r1");
            keyGen.initialize(ecSpec, new SecureRandom());
            KeyPair ec_keypair = keyGen.generateKeyPair();
            System.out.println("EC KeyPair generated successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}