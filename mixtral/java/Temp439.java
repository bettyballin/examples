import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.DLSequence;
import org.bouncycastle.asn1.DERInteger;
import java.math.BigInteger;

public class Temp439 {
    public static void main(String[] args) {
        Temp439 temp = new Temp439();
        byte[] signature = {};  // Replace with actual signature byte array
        boolean result = temp.isRSASignature(signature);
        System.out.println("Is RSA Signature: " + result);
    }

    public boolean isRSASignature(byte[] signature) {
        try {
            ASN1InputStream asn1 = new ASN1InputStream(signature);

            // Check if the input starts with a SEQUENCE
            DLSequence seq = (DLSequence) asn1.readObject();

            // The first element should be an INTEGER
            BigInteger rsaInt = ((DERInteger) (seq.getObjectAt(0))).getValue();

        } catch (Exception e) {
            return false;
        }

        return true;
    }
}