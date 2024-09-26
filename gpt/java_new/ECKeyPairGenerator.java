import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.ECPoint;

public class ECKeyPairGenerator {
    public static void main(String[] args) throws Exception {
        // Initialize a key pair generator
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("EC");
        keyPairGenerator.initialize(new ECGenParameterSpec("secp256r1"));

        // Generate the key pair
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        ECPrivateKey privateKey = (ECPrivateKey) keyPair.getPrivate();

        // Generate public key from private key
        KeyFactory keyFactory = KeyFactory.getInstance("EC");
        ECParameterSpec params = privateKey.getParams();
        ECPoint Q = privateKey.getParams().getCurve().createPoint(privateKey.getS(), privateKey.getS(), false);

        ECPublicKeySpec pubKeySpec = new ECPublicKeySpec(Q, params);
        ECPublicKey publicKeyGenerated = (ECPublicKey) keyFactory.generatePublic(pubKeySpec);

        // Now you should have the correct public key generated from the private key
    }
}