import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.Security;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class Temp3280 {
    public static void main(String[] args) {
        try {
            Security.addProvider(new BouncyCastleProvider());

            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("DH", "BC");
            keyGen.initialize(2048);
            KeyPair pair = keyGen.generateKeyPair();
            PrivateKey prv = pair.getPrivate();

            BigInteger onezero = new BigInteger("00", 16);
            ASN1EncodableVector algid = new ASN1EncodableVector();
            algid.add(new DERObjectIdentifier(PKCSObjectIdentifiers.dhKeyAgreement.getId()));
            algid.add(new DERNull());

            ASN1EncodableVector v = new ASN1EncodableVector();
            v.add(new DERInteger(onezero));
            v.add(new DERSequence(algid));
            v.add(new DEROctetString(prv.getEncoded()));
            DERSequence pkcs8 = new DERSequence(v);

            System.out.println(bytesToHex(pkcs8.getEncoded()));
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