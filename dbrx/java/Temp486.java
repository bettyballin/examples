import org.bouncycastle.jce.ECNamedCurveTable;
import org.bouncycastle.jce.interfaces.ECPublicKey;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.spec.ECParameterSpec;
import org.bouncycastle.jce.spec.ECPublicKeySpec;
import org.bouncycastle.math.ec.ECPoint;

import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.Security;
import java.security.spec.InvalidKeySpecException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.Arrays;

public class Temp486 {
    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    public static void main(String[] args) {
        // Example usage
        byte[] raw = new byte[64]; // Replace this with actual raw byte array
        Temp486 temp = new Temp486();
        try {
            ECPublicKey publicKey = temp.getPublicKey(raw);
            System.out.println(publicKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ECPublicKey getPublicKey(byte[] raw) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeySpecException {
        ECParameterSpec ecSpec = ECNamedCurveTable.getParameterSpec("secp256r1");
        KeyFactory kf = KeyFactory.getInstance("EC", "BC");

        BigInteger x = new BigInteger(1, Arrays.copyOfRange(raw, 0, 32));
        BigInteger y = new BigInteger(1, Arrays.copyOfRange(raw, 32, 64));

        ECPoint point = ecSpec.getCurve().createPoint(x, y);
        ECPublicKeySpec pubKey = new ECPublicKeySpec(point, ecSpec);

        return (ECPublicKey) kf.generatePublic(pubKey);
    }
}