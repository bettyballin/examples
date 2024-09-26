import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidKeyException;
import java.security.spec.PKCS8EncodedKeySpec;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.DERSequence;

public class Temp1026 {
    private static PrivateKey privateKey; 

    public static void main(String[] args) throws Exception {
        // Generate a private key
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("EC");
        kpg.initialize(256);
        KeyPair kp = kpg.generateKeyPair();
        privateKey = kp.getPrivate();

        byte[] content = "random string".getBytes();
        Signature dsa = Signature.getInstance("SHA256withECDSA");
        dsa.initSign(privateKey);
        dsa.update(content);
        byte[] signature = dsa.sign();

        // Parse the DER-encoded byte array
        ASN1Integer r = null, s = null;
        try (ASN1InputStream asn1Stream = new ASN1InputStream(new ByteArrayInputStream(signature))) {
            DERSequence seq = (DERSequence) asn1Stream.readObject();
            r = (ASN1Integer) seq.getObjectAt(0);
            s = (ASN1Integer) seq.getObjectAt(1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Now you can use 'r' and 's'
        System.out.println("r: " + r.getValue());
        System.out.println("s: " + s.getValue());
    }
}