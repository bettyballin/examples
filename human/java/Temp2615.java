import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Encoding;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.ASN1Integer;

public class Temp2615 {
    public static void main(String[] args) {
        // Sample integers for demonstration purposes
        int r = 12345;
        int s = 67890;

        ASN1EncodableVector v = new ASN1EncodableVector();
        v.add(new ASN1Integer(r));
        v.add(new ASN1Integer(s));

        try {
            byte[] derEncodedSignature = new DERSequence(v).getEncoded(ASN1Encoding.DER);
            System.out.println(java.util.Arrays.toString(derEncodedSignature));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}