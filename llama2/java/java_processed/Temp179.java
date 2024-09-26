import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.spec.ECGenParameterSpec;

public class Temp179 {
    public static void main(String[] args) {
        try {
            KeyPairGenerator kpg = KeyPairGenerator.getInstance("EC");
            ECGenParameterSpec ecsp = new ECGenParameterSpec("secp256r1");
            kpg.initialize(ecsp);

            KeyPair kp = kpg.generateKeyPair();
            System.out.println("Key Pair Generated Successfully");
            System.out.println("Private Key: " + kp.getPrivate().toString());
            System.out.println("Public Key: " + kp.getPublic().toString());

        } catch (NoSuchAlgorithmException | java.security.InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        }
    }
}