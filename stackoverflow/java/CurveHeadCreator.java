import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.InvalidAlgorithmParameterException;
import java.util.Arrays;

public class CurveHeadCreator {
    private static byte[] createHeadForNamedCurve(String name, int size)
            throws NoSuchAlgorithmException, InvalidAlgorithmParameterException {
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("EC");
        ECGenParameterSpec ecSpec = new ECGenParameterSpec(name);
        kpg.initialize(ecSpec);
        KeyPair kp = kpg.generateKeyPair();
        byte[] encoded = kp.getPublic().getEncoded();
        return Arrays.copyOf(encoded, encoded.length - 2 * (size / Byte.SIZE));
    }
}