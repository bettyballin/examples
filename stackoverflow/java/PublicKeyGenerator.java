import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;
import java.security.spec.InvalidKeySpecException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidParameterSpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class PublicKeyGenerator {
    public static PublicKey generateP256PublicKeyFromFlatW(byte[] w) throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidParameterSpecException {
        KeyFactory keyFactory = KeyFactory.getInstance("EC");

        ECParameterSpec ecParameterSpec = java.security.AlgorithmParameters.getInstance("EC").getParameterSpec(ECParameterSpec.class);
        EllipticCurve ellipticCurve = ecParameterSpec.getCurve();

        ECPoint ecPoint = new ECPoint(
            ellipticCurve.getField().getFieldElement(w, 0, 32),
            ellipticCurve.getField().getFieldElement(w, 32, 32)
        );

        ECPublicKeySpec ecPublicKeySpec = new ECPublicKeySpec(ecPoint, ecParameterSpec);
        return keyFactory.generatePublic(ecPublicKeySpec);
    }

    public static void main(String[] args) {
        byte[] w = Base64.getDecoder().decode("REPLACE_WITH_BASE64_ENCODED_FLAT_W");
        try {
            PublicKey key = generateP256PublicKeyFromFlatW(w);
            System.out.println(key);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException | InvalidParameterSpecException e) {
            e.printStackTrace();
        }
    }
}