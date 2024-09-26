import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.sec.ECPrivateKeyStructure;
import org.bouncycastle.asn1.ASN1Sequence;

public class Temp2222 {
    public static void main(String[] args) {
        // Example private key bytes, replace with actual bytes
        byte[] privateKeyBytes = new byte[]{1, 2, 3, 4, 5};

        ASN1EncodableVector v = new ASN1EncodableVector();
        v.add(new ASN1Integer(privateKeyBytes));

        ASN1Sequence sequence = new DERSequence(v);
        ECPrivateKeyStructure ecPkStruct = new ECPrivateKeyStructure(sequence);

        // Example public point, replace with actual public point
        // publicPoint can be created using appropriate methods
        // This line is commented out because the context is incomplete
        // Object publicPoint = ecPkStruct.getPublicKey();

        // Printing the structure as an example
        System.out.println(ecPkStruct);
    }
}