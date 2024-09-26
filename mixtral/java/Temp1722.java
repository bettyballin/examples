import org.bouncycastle.asn1.*;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;

import javax.xml.bind.DatatypeConverter;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;

public class Temp1722 {
    public static void main(String[] args) {
        try {
            String hexStr = "your_hex_string_here"; // Replace with your hex string
            PublicKey publicKey = new Temp1722().getPublicKey(hexStr);
            System.out.println(publicKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public PublicKey getPublicKey(String hexStr) throws Exception {
        byte[] bytes = DatatypeConverter.parseHexBinary(hexStr);

        // Wrap with ASN.1 encoding for EC keys
        ASN1EncodableVector v = new ASN1EncodableVector();

        // Add OID
        ASN1ObjectIdentifier oid = X9ObjectIdentifiers.id_ecPublicKey;
        ASN1ObjectIdentifier curveOid = X9ObjectIdentifiers.prime256v1;

        v.add(new DERSequence(new ASN1Encodable[]{oid, curveOid}));

        DERBitString bitstring = new DERBitString(bytes);

        // Add public key bytes
        v.add(bitstring);

        DERSequence seq = new DERSequence(v);
        byte[] encodedPublicKey = seq.getEncoded();

        KeyFactory kf = KeyFactory.getInstance("EC");

        X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(encodedPublicKey);

        PublicKey pubkey = kf.generatePublic(publicKeySpec);

        return pubkey;
    }
}