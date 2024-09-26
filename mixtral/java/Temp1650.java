import org.bouncycastle.asn1.*;
import org.bouncycastle.asn1.sec.SECNamedCurves;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.math.ec.ECPoint;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.ECPoint as JavaECPoint;
import java.util.Base64;

public class Main {
    public static void main(String[] args) throws Exception {
        String key = "base64 encoded publicRawBytes"; // Replace with actual base64 encoded string
        byte[] byteKey = Base64.getDecoder().decode(key);

        ASN1InputStream asin = new ASN1InputStream(new ByteArrayInputStream(byteKey));

        DEROctetString octStr = (DEROctetString) asin.readObject();

        X9ECParameters ecParams = SECNamedCurves.getByName("secp256r1");
        ECPoint point = ecParams.getCurve().decodePoint(octStr.getOctets());

        ECDomainParameters ecDomainParams = new ECDomainParameters(
                ecParams.getCurve(),
                ecParams.getG(),
                ecParams.getN(),
                ecParams.getH()
        );

        ECParameterSpec ecSpec = new ECParameterSpec(
                ecParams.getCurve(),
                new JavaECPoint(
                        ecParams.getG().getAffineXCoord().toBigInteger(),
                        ecParams.getG().getAffineYCoord().toBigInteger()
                ),
                ecParams.getN(),
                ecParams.getH().intValue()
        );

        ECPublicKeySpec keySpec = new ECPublicKeySpec(
                new JavaECPoint(
                        point.getAffineXCoord().toBigInteger(),
                        point.getAffineYCoord().toBigInteger()
                ),
                ecSpec
        );

        KeyFactory keyFactory = KeyFactory.getInstance("EC");
        PublicKey publicKey = keyFactory.generatePublic(keySpec);

        System.out.println(publicKey);
    }
}