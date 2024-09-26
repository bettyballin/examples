import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;

public class Temp2446 {
    public static void main(String[] args) {
        try {
            KeyPairGenerator kpg = KeyPairGenerator.getInstance("EC");
            kpg.initialize(256); // You can specify the key size
            KeyPair ephemeralKeyPair = kpg.generateKeyPair();
            ECPublicKey ephemeralPublicKey = (ECPublicKey) ephemeralKeyPair.getPublic();
            ECPrivateKey clientEphemeralPrivateKey = (ECPrivateKey) ephemeralKeyPair.getPrivate();

            System.out.println("Ephemeral Public Key: " + ephemeralPublicKey);
            System.out.println("Client Ephemeral Private Key: " + clientEphemeralPrivateKey);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}