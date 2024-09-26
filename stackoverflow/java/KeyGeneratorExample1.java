import java.security.KeyPairGenerator;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECGenParameterSpec;
import java.security.SecureRandom;
import java.security.KeyFactory;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPublicKeySpec;
import org.bouncycastle.jce.ECNamedCurveTable;

public class KeyGeneratorExample1 {
    public static void main(String[] args) throws Exception {
        // Generate Keys
        ECGenParameterSpec ecGenSpec = new ECGenParameterSpec("secp256r1");
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("ECDSA");
        keyPairGenerator.initialize(ecGenSpec, new SecureRandom());
        KeyPair pair = keyPairGenerator.generateKeyPair();
        ECPrivateKey privateKey = (ECPrivateKey) pair.getPrivate();
        ECPublicKey publicKeyExpected = (ECPublicKey) pair.getPublic();

        // Expected public key
        System.out.println("Expected Public Key: " +
                java.util.Base64.getUrlEncoder().encodeToString(publicKeyExpected.getEncoded()));

        // Generate public key from private key
        KeyFactory keyFactory = KeyFactory.getInstance("ECDSA");
        ECParameterSpec ecSpec = ECNamedCurveTable.getParameterSpec("secp256r1");

        ECPoint Q = ecSpec.getG().multiply(privateKey.getS());
        ECPublicKeySpec pubSpec = new ECPublicKeySpec(Q, ecSpec);
        ECPublicKey publicKeyGenerated = (ECPublicKey) keyFactory.generatePublic(pubSpec);

        // Generated public key from private key
        System.out.println("Generated Public Key: " +
                java.util.Base64.getUrlEncoder().encodeToString(publicKeyGenerated.getEncoded()));
    }
}