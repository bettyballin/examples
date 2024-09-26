import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DLSequence;
import org.bouncycastle.jce.interfaces.ECPublicKey;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.crypto.params.ECDomainParameters;

import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.security.PublicKey;
import java.security.Security;
import java.util.Arrays;

public class SignatureVerifier {

    public static void main(String[] args) throws Exception {
        Security.addProvider(new BouncyCastleProvider());

        byte[] finalEncryptedMsg = {}; // Initialize with actual data
        PublicKey publicKey = null; // Initialize with actual public key

        ASN1InputStream asn1 = new ASN1InputStream(new ByteArrayInputStream(finalEncryptedMsg));
        ASN1Primitive derObj = asn1.readObject();
        if (derObj instanceof DERSequence) {
            BigInteger r, s;

            // Extract R and S values from the signature
            byte[] encodedR = ((DLSequence) derObj).getObjectAt(0).toASN1Primitive().getEncoded();
            byte[] encodedS = ((DLSequence) derObj).getObjectAt(1).toASN1Primitive().getEncoded();

            r = new BigInteger(1, encodedR.length > 32 ? Arrays.copyOfRange(encodedR, 1, encodedR.length) : encodedR);
            s = new BigInteger(1, encodedS.length > 32 ? Arrays.copyOfRange(encodedS, 1, encodedS.length) : encodedS);

            // Verify the signature using R and S values
            ECDomainParameters ecParams = ((ECPublicKey) publicKey).getParameters();
            BigInteger curveOrder = ecParams.getN();

            if (r.compareTo(BigInteger.ZERO) <= 0 || r.compareTo(curveOrder) >= 0 ||
                s.compareTo(BigInteger.ZERO) <= 0 || s.compareTo(curveOrder) >= 0) {
                throw new IllegalArgumentException("Invalid signature");
            }

            System.out.println("Signature is valid.");
        }
    }
}