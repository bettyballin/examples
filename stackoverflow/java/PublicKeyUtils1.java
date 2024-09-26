import java.security.spec.ECPoint;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.security.KeyFactory;
import java.security.interfaces.ECPublicKey;
import java.util.Arrays;
import java.security.spec.EllipticCurve;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECGenParameterSpec;
import java.security.NoSuchAlgorithmException;

public class PublicKeyUtils1 {

    public static ECPublicKey generateP256PublicKeyFromUncompressedW(byte[] w) throws InvalidKeySpecException, NoSuchAlgorithmException {
        if (w[0] != 0x04) {
            throw new InvalidKeySpecException("w is not an uncompressed key");
        }

        byte[] x = Arrays.copyOfRange(w, 1, 33);
        byte[] y = Arrays.copyOfRange(w, 33, 65);

        KeyFactory keyFactory = KeyFactory.getInstance("EC");
        ECParameterSpec ecSpec = keyFactory.getKeySpec(keyFactory.generatePublic(new ECPublicKeySpec(new ECPoint(new java.math.BigInteger(1, x), new java.math.BigInteger(1, y)), null)), ECParameterSpec.class);
        ECPoint point = new ECPoint(new java.math.BigInteger(1, x), new java.math.BigInteger(1, y));

        ECPublicKeySpec ecPublicKeySpec = new ECPublicKeySpec(point, ecSpec);
        return (ECPublicKey) keyFactory.generatePublic(ecPublicKeySpec);
    }
}