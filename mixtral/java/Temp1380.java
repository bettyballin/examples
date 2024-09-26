import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Security;
import java.security.spec.ECGenParameterSpec;
import java.util.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class Temp1380 {
    public static void main(String[] args) {
        try {
            String publicKey = serverSidePublicKeyGenration();
            System.out.println("Public Key: " + publicKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String serverSidePublicKeyGenration() throws Exception {
        Security.addProvider(new BouncyCastleProvider());

        KeyPairGenerator kpg = KeyPairGenerator.getInstance("EC");
        ECGenParameterSpec ecsp;

        // Use secp256r1 curve
        ecsp = new ECGenParameterSpec("secp256r1");

        kpg.initialize(ecsp);

        KeyPair keyPair = kpg.generateKeyPair();

        return Base64.getEncoder().encodeToString((keyPair.getPublic()).getEncoded());
    }
}