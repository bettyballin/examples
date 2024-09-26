import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

public class Temp2782 {
    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException {
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("EC");
        kpg.initialize(new ECGenParameterSpec("secp256r1"));
        KeyPair kp = kpg.generateKeyPair();
        ECPublicKey publicKey = (ECPublicKey) kp.getPublic();
        System.out.println("Encoding format: " + publicKey.getFormat());
        byte[] derEncoded = publicKey.getEncoded();
        // base64 encoded is what you get for PEM, between the header and footer lines
        String base64DEREncoded = Base64.getEncoder().encodeToString(derEncoded);
        System.out.println("Base64 SubjectPublicKeyInfo: " + base64DEREncoded);
    }
}