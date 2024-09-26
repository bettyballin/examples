import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.jce.spec.ECParameterSpec;
import org.bouncycastle.jce.ECNamedCurveTable;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Security;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.ECGenParameterSpec;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        Security.addProvider(new BouncyCastleProvider());

        byte[] rawKey = new byte[64]; // Your 64-bytes key here
        BigInteger r = new BigInteger(1, Arrays.copyOfRange(rawKey, 0, 32));
        BigInteger s = new BigInteger(1, Arrays.copyOfRange(rawKey, 32, 64));

        X9ECParameters x9Params = ECNamedCurveTable.getByName("P-256");
        ECCurve curve = x9Params.getCurve();

        java.security.spec.ECParameterSpec ecParamSpec = new java.security.spec.ECParameterSpec(
                curve,
                x9Params.getG(),
                x9Params.getN(),
                x9Params.getH()
        );

        ECPoint point = ecParamSpec.getGenerator().multiply(new BigInteger(1, rawKey));

        java.security.spec.ECPublicKeySpec pubKeySpec = new java.security.spec.ECPublicKeySpec(
                new java.security.spec.ECPoint(point.getAffineXCoord().toBigInteger(), point.getAffineYCoord().toBigInteger()),
                ecParamSpec
        );

        KeyFactory keyFact = KeyFactory.getInstance("EC", "BC");
        PublicKey publicKey = keyFact.generatePublic(pubKeySpec);

        System.out.println(publicKey);
    }
}