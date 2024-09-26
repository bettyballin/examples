import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPrivateKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.InvalidParameterSpecException;
import java.util.Arrays;

public class Temp3271 {
    public static void main(String[] args) {
        // Example usage
        byte[] rawBytes = new byte[97]; // Example byte array
        try {
            PrivateKey privateKey = new Temp3271().createECPrivateKey(rawBytes);
            System.out.println("Private Key: " + privateKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private PrivateKey createECPrivateKey(byte[] rawBytes) throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidParameterSpecException {
        KeyFactory kf = KeyFactory.getInstance("EC");
        BigInteger s = new BigInteger(Arrays.copyOfRange(rawBytes, 65, rawBytes.length));
        return kf.generatePrivate(new ECPrivateKeySpec(s, ecParameterSpecForCurve("secp256r1")));
    }

    private ECParameterSpec ecParameterSpecForCurve(String curveName) throws NoSuchAlgorithmException, InvalidParameterSpecException {
        ECGenParameterSpec ecGenParameterSpec = new ECGenParameterSpec(curveName);
        return KeyFactory.getInstance("EC").getKeySpec(KeyFactory.getInstance("EC").generatePublic(new ECGenParameterSpec(curveName)), ECParameterSpec.class);
    }
}