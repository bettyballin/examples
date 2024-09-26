import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.jce.spec.ECNamedCurveParameterSpec;
import org.bouncycastle.jce.ECNamedCurveTable;

import java.security.Security;
import java.security.PublicKey;

public class Temp2872 {
    public static void main(String[] args) {
        Security.addProvider(new BouncyCastleProvider());

        try {
            // For demonstration purposes, we use a dummy public key
            // In practice, you would replace this with your actual public key
            PublicKey publicKey = ...; // Initialize with your actual public key

            byte[] encoded = publicKey.getEncoded();
            ASN1Sequence asn1Primitive = ASN1Sequence.getInstance(encoded);
            ASN1Encodable algorithmIdentifier = asn1Primitive.getObjectAt(0);
            DERBitString ecPointBitString = (DERBitString) asn1Primitive.getObjectAt(1);

            // Use named curve parameters (for example, secp256k1)
            ECNamedCurveParameterSpec curveParams = ECNamedCurveTable.getParameterSpec("secp256k1");
            ECPoint ecPoint = curveParams.getCurve().decodePoint(ecPointBitString.getOctets());
            byte[] x = ecPoint.getAffineXCoord().getEncoded();
            byte[] y = ecPoint.getAffineYCoord().getEncoded();

            // Print the coordinates for verification
            System.out.println("X: " + bytesToHex(x));
            System.out.println("Y: " + bytesToHex(y));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}


Note: You'll need the BouncyCastle library for this code to work. You can add the BouncyCastle dependency to your project using Maven or by manually including the JAR files in your classpath.