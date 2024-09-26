import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Base64;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.crypto.generators.DHParametersGenerator;
import org.bouncycastle.crypto.params.DHParameters;

public class OpenSSLDHParamClone {

    public static void main(String[] args) throws Exception {
        DHParametersGenerator generator = new DHParametersGenerator();
        generator.init(1024, 80, new SecureRandom());
        DHParameters params = generator.generateParameters();
        // Generator G is set as random in params, but it has to be 2 to conform to openssl
        DHParameters realParams = new DHParameters(params.getP(), BigInteger.valueOf(2));
        ASN1EncodableVector seq = new ASN1EncodableVector();
        seq.add(new ASN1Integer(realParams.getP()));
        seq.add(new ASN1Integer(realParams.getG()));
        byte[] derEncoded = new DERSequence(seq).getEncoded();
        System.out.println("-----BEGIN DH PARAMETERS-----");
        String b64Encoded = Base64.getEncoder().encodeToString(derEncoded);
        for (int i = 0; i < b64Encoded.length(); i += 64) {
            System.out.println(b64Encoded.substring(i, Math.min(i + 64, b64Encoded.length())));
        }
        System.out.println("-----END DH PARAMETERS-----");
    }
}