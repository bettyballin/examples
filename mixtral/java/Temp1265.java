import org.bouncycastle.asn1.*;
import org.bouncycastle.asn1.x9.*;
import org.bouncycastle.jce.ECNamedCurveTable;
import org.bouncycastle.jce.spec.ECNamedCurveParameterSpec;
import org.bouncycastle.math.ec.ECPoint;

import java.math.BigInteger;

public class Temp1265 {
    public static void main(String[] args) {
        // Assuming privateKey.getS() is defined and returns a BigInteger
        BigInteger s = new BigInteger("your_private_key_here");

        // Get curve parameters
        ECNamedCurveParameterSpec spec = ECNamedCurveTable.getParameterSpec("secp256r1");
        X9ECParameters ecP = new X9ECParameters(spec.getCurve(), spec.getG(), spec.getN(), spec.getH());

        // Calculate Q
        ECPoint q = ecP.getG().multiply(s);

        // Convert to ASN1
        X9IntegerConverter x9intConvertor = new X9IntegerConverter();
        ASN1EncodableVector v2 = new ASN1EncodableVector();
        v2.add(new DEROctetString(x9intConvertor.integerToBytes(q.getAffineXCoord().toBigInteger(), x9intConvertor.getByteLength(q))));
        v2.add(new DEROctetString(x9intConvertor.integerToBytes(q.getAffineYCoord().toBigInteger(), x9intConvertor.getByteLength(q))));
        DERObjectIdentifier oid = new DERObjectIdentifier(ecP.getCurve().getField().getFieldName());
        ASN1EncodableVector v = new ASN1EncodableVector();
        v.add(oid);
        v.add(new DERSequence(v2));

        // To encode the ASN1EncodableVector to a byte array
        DERSequence sequence = new DERSequence(v);
        byte[] encoded = sequence.getEncoded(ASN1Encoding.DER);

        // Print the resulting DER encoded byte array
        System.out.println(java.util.Arrays.toString(encoded));
    }
}