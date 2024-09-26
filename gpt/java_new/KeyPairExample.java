import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;

public class KeyPairExample {
    public static void main(String[] args) {
        try {
            KeyPairGenerator kpg = KeyPairGenerator.getInstance("EC");
            KeyPair keyPair = kpg.generateKeyPair();
            ECPublicKey ephemeralPublicKey = (ECPublicKey) keyPair.getPublic();
            ECPrivateKey clientEphemeralPrivateKey = (ECPrivateKey) keyPair.getPrivate();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}