import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidAlgorithmParameterException;
import java.security.spec.ECGenParameterSpec;

public class Temp180 {
    public static void main(String[] args) {
        try {
            ECGenParameterSpec ecParams = new ECGenParameterSpec("prime256v1");
            KeyPairGenerator kpg = KeyPairGenerator.getInstance("EC");
            kpg.initialize(ecParams);
            KeyPair kp = kpg.generateKeyPair();
            System.out.println("Key Pair Generated Successfully");
        } catch (NoSuchAlgorithmException | InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        }
    }
}