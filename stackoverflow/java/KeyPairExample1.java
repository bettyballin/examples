import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;

public class KeyPairExample1 {
    public static void main(String[] args) {
        try {
            KeyPairGenerator kpg = KeyPairGenerator.getInstance("EC");
            KeyPair clientEphemeralKeyPair = kpg.generateKeyPair();
            ECPublicKey clientEphemeralPublicKey = (ECPublicKey) clientEphemeralKeyPair.getPublic();
            ECPrivateKey clientEphemeralPrivateKey = (ECPrivateKey) clientEphemeralKeyPair.getPrivate();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}