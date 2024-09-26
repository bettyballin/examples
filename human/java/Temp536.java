import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.Security;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.openssl.PEMParser;

public class Temp536 {
    public static void main(String[] args) {
        try {
            // Load the signer's certificate
            FileInputStream certFileStream = new FileInputStream("myCrtFile.crt");
            CertificateFactory certFactory = CertificateFactory.getInstance("X.509");
            X509Certificate signerCert = (X509Certificate) certFactory.generateCertificate(certFileStream);
            X509CertificateHolder signerCertHolder = new X509CertificateHolder(signerCert.getEncoded());

            // Load the private key
            FileInputStream keyFileStream = new FileInputStream("myKeyFile.key");
            byte[] keyBytes = keyFileStream.readAllBytes();
            String keyString = new String(keyBytes).replaceAll("-----\\w+ PRIVATE KEY-----", "").replaceAll("\\s+", "");
            byte[] decodedKey = Base64.getDecoder().decode(keyString);
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(decodedKey);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PrivateKey privateKey = keyFactory.generatePrivate(keySpec);

            // Load the bundle certificate
            FileInputStream bundleCertFileStream = new FileInputStream("bundleCertificate.crt");
            PEMParser pemParser = new PEMParser(new java.io.InputStreamReader(bundleCertFileStream));
            X509CertificateHolder certificateHolder = (X509CertificateHolder) pemParser.readObject();
            pemParser.close();

            // Output for verification (optional)
            System.out.println("Signer's Certificate Holder: " + signerCertHolder);
            System.out.println("Private Key: " + privateKey);
            System.out.println("Bundle Certificate Holder: " + certificateHolder);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}