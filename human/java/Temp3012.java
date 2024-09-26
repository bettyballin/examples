import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

public class Temp3012 {
    public static void main(String[] args) {
        secret();
    }

    static void secret() {
        KeyPairGenerator kpg = null;
        try {
            kpg = KeyPairGenerator.getInstance("RSA");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        kpg.initialize(2048);
        KeyPair kp = kpg.generateKeyPair();
        PublicKey pubkey = kp.getPublic();
        PrivateKey privkey = kp.getPrivate();
        System.out.println(java.util.Base64.getEncoder().encodeToString(privkey.getEncoded()) + "---" + java.util.Base64.getEncoder().encodeToString(pubkey.getEncoded()));
    }
}