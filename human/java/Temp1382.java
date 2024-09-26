import java.security.*;
import java.security.spec.ECGenParameterSpec;
import java.util.Arrays;
import java.io.IOException;

public class Temp1382 {
    public static void main(String[] args) {
        try {
            byte[] result = createHeadForNamedCurve("secp256r1", 256);
            System.out.println(Arrays.toString(result));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static byte[] createHeadForNamedCurve(String name, int size)
            throws NoSuchAlgorithmException, InvalidAlgorithmParameterException, IOException {
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("EC");
        ECGenParameterSpec m = new ECGenParameterSpec(name);
        kpg.initialize(m);
        KeyPair kp = kpg.generateKeyPair();
        byte[] encoded = kp.getPublic().getEncoded();
        return Arrays.copyOf(encoded, encoded.length - 2 * (size / Byte.SIZE));
    }
}