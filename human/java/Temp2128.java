import java.security.*;
import java.security.spec.*;
import java.util.Base64;
import javax.crypto.KeyAgreement;
import org.bouncycastle.jce.ECNamedCurveTable;
import org.bouncycastle.jce.spec.ECParameterSpec;
import org.bouncycastle.jce.spec.ECPublicKeySpec;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.jce.interfaces.ECPrivateKey;
import org.bouncycastle.jce.interfaces.ECPublicKey;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class Temp2128 {
    public static void main(String[] args) throws Exception {
        Security.addProvider(new BouncyCastleProvider());

        // Generate Keys
        ECGenParameterSpec ecGenSpec = new ECGenParameterSpec("secp256r1");
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("ECDSA", "BC");
        keyPairGenerator.initialize(ecGenSpec, new SecureRandom());
        KeyPair pair = keyPairGenerator.generateKeyPair();
        ECPrivateKey privateKey = (ECPrivateKey) pair.getPrivate();
        ECPublicKey publicKeyExpected = (ECPublicKey) pair.getPublic();

        // Expected public key
        System.out.println("Expected Public Key: " +
                Base64.getUrlEncoder().encodeToString(publicKeyExpected.getEncoded()));

        // Generate public key from private key
        KeyFactory keyFactory = KeyFactory.getInstance("ECDSA", "BC");
        ECParameterSpec ecSpec = ECNamedCurveTable.getParameterSpec("secp256r1");

        ECPoint Q = ecSpec.getG().multiply(privateKey.getD());
        ECPublicKeySpec pubSpec = new ECPublicKeySpec(Q, ecSpec);
        ECPublicKey publicKeyGenerated = (ECPublicKey) keyFactory.generatePublic(pubSpec);

        // Generated public key from private key
        System.out.println("Generated Public Key: " +
                Base64.getUrlEncoder().encodeToString(publicKeyGenerated.getEncoded()));
    }
}