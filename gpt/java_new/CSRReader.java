import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.cert.jcajce.JcaPKCS10CertificationRequest;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openssl.PEMParser;
import java.io.FileReader;
import java.security.PublicKey;
import java.security.Security;
import java.security.KeyFactory;
import java.security.spec.X509EncodedKeySpec;

public class CSRReader {

    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    public static void main(String[] args) throws Exception {
        PEMParser pemParser = new PEMParser(new FileReader("csr.pem"));
        Object parsedObj = pemParser.readObject();
        pemParser.close();

        if (parsedObj instanceof JcaPKCS10CertificationRequest) {
            JcaPKCS10CertificationRequest csr = (JcaPKCS10CertificationRequest) parsedObj;
            
            // Extracting the SubjectPublicKeyInfo
            SubjectPublicKeyInfo pkInfo = csr.getSubjectPublicKeyInfo();
            
            // Converting SubjectPublicKeyInfo to PublicKey
            X509EncodedKeySpec spec = new X509EncodedKeySpec(pkInfo.getEncoded());
            KeyFactory kf = KeyFactory.getInstance(pkInfo.getAlgorithm().getAlgorithm().getId());
            PublicKey pubKey = kf.generatePublic(spec);
            
            System.out.println("Public Key Algorithm: " + pubKey.getAlgorithm());
        }
    }
}