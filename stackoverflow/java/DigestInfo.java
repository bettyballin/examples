// This is an ASN.1 schema definition and not Java code. It can't be refactored to Java directly.
// However, a corresponding Java class using Bouncy Castle ASN.1 classes might look like this:

import org.bouncycastle.asn1.*;

public class DigestInfo extends ASN1Object {
    private AlgorithmIdentifier digestAlgorithm;
    private ASN1OctetString digest;

    public DigestInfo(AlgorithmIdentifier digestAlgorithm, byte[] digest) {
        this.digestAlgorithm = digestAlgorithm;
        this.digest = new DEROctetString(digest);
    }

    public static DigestInfo getInstance(Object obj) {
        if (obj instanceof DigestInfo) {
            return (DigestInfo) obj;
        } else if (obj != null) {
            return new DigestInfo(ASN1Sequence.getInstance(obj));
        }

        return null;
    }

    private DigestInfo(ASN1Sequence seq) {
        if (seq.size() != 2) {
            throw new IllegalArgumentException("Bad sequence size: " + seq.size());
        }

        this.digestAlgorithm = AlgorithmIdentifier.getInstance(seq.getObjectAt(0));
        this.digest = ASN1OctetString.getInstance(seq.getObjectAt(1));
    }

    public AlgorithmIdentifier getDigestAlgorithm() {
        return digestAlgorithm;
    }

    public ASN1OctetString getDigest() {
        return digest;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v = new ASN1EncodableVector();
        v.add(digestAlgorithm);
        v.add(digest);
        return new DERSequence(v);
    }
}