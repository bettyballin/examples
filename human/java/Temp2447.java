import java.security.*;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;

public class Temp2447 {
    public static void main(String[] args) {
        try {
            KeyPairGenerator kpg = KeyPairGenerator.getInstance("EC");
            kpg.initialize(256); // Specify the key size (256 bits)
            KeyPair clientEphemeralKeyPair = kpg.generateKeyPair();
            ECPublicKey clientEphemeralPublicKey = (ECPublicKey) clientEphemeralKeyPair.getPublic();
            ECPrivateKey clientEphemeralPrivateKey = (ECPrivateKey) clientEphemeralKeyPair.getPrivate();
            
            System.out.println("Public Key: " + clientEphemeralPublicKey);
            System.out.println("Private Key: " + clientEphemeralPrivateKey);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}