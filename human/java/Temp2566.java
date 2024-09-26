import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import java.security.spec.ECGenParameterSpec;
import java.util.Arrays;
import javax.xml.bind.DatatypeConverter;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.sec.SECObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x9.X962Parameters;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.jcajce.provider.asymmetric.ec.BCECPublicKey;
import org.bouncycastle.jcajce.provider.asymmetric.util.EC5Util;
import org.bouncycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.bouncycastle.jcajce.provider.config.ProviderConfiguration;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;
import java.security.Security;

public class Main {
    public static void main(String[] args) throws Exception {
        Security.addProvider(new BouncyCastleProvider());

        KeyPairGenerator kpg = KeyPairGenerator.getInstance("EC", "BC");
        kpg.initialize(new ECGenParameterSpec("secp521r1"));
        BCECPublicKey ku = (BCECPublicKey)kpg.generateKeyPair().getPublic();
        byte[] encodedpoint = ku.getQ().getEncoded(true);

        { // construct SPKI by hand, this curve only
            byte[] hdr = DatatypeConverter.parseHexBinary("3058301006072a8648ce3d020106052b81040023034400");
            if (0x44 - 1 != encodedpoint.length) throw new Exception("BAD COMPRESSED POINT FOR secp521r1!");
            byte[] spki = Arrays.copyOf(hdr, 90);
            System.arraycopy(encodedpoint, 0, spki, 0x17, 0x43);
            PublicKey k2 = KeyFactory.getInstance("EC").generatePublic(new X509EncodedKeySpec(spki));
            Signature.getInstance("ECDSA").initVerify(k2); // sanity check
        }
        { // construct SPKI with BC
            AlgorithmIdentifier algid = new AlgorithmIdentifier(X9ObjectIdentifiers.id_ecPublicKey, SECObjectIdentifiers.secp521r1);
            ASN1EncodableVector vec = new ASN1EncodableVector();
            vec.add(algid);
            vec.add(new DERBitString(encodedpoint));
            byte[] spki = new DERSequence(vec).getEncoded();
            PublicKey k2 = KeyFactory.getInstance("EC").generatePublic(new X509EncodedKeySpec(spki));
            Signature.getInstance("ECDSA").initVerify(k2); // sanity check
        }
        { // call BC directly
            ProviderConfiguration configuration = BouncyCastleProvider.CONFIGURATION;
            X962Parameters params = X962Parameters.getInstance(SECObjectIdentifiers.secp521r1);
            ECCurve curve = EC5Util.getCurve(configuration, params);
            ECPoint point = curve.decodePoint(encodedpoint).normalize();
            ECPublicKeyParameters kparams = new ECPublicKeyParameters(point, ECUtil.getDomainParameters(configuration, params));
            PublicKey k2 = new BCECPublicKey("EC", kparams, configuration);
            Signature.getInstance("ECDSA").initVerify(k2); // sanity check
        }
    }
}