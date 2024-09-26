import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.InvalidKeySpecException;

public class PublicKeyGenerator {

    public PublicKey generatePublicKeyFrom(byte[] x, byte[] y) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchProviderException {
        KeyFactory keyFactory = KeyFactory.getInstance("EC");
        ECPoint ecPoint = new ECPoint(new java.math.BigInteger(1, x), new java.math.BigInteger(1, y));
        ECGenParameterSpec ecGenParameterSpec = new ECGenParameterSpec("secp256r1");
        ECParameterSpec ecParameterSpec = keyFactory.getKeySpec(keyFactory.generatePublic(new ECPublicKeySpec(ecPoint, ecParameterSpec)), ECParameterSpec.class);
        ECPublicKeySpec ecPublicKeySpec = new ECPublicKeySpec(ecPoint, ecParameterSpec);
        return keyFactory.generatePublic(ecPublicKeySpec);
    }
}