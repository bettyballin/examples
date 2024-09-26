import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.openssl.PEMParser;
import org.bouncycastle.openssl.jcajce.JcaPEMKeyConverter;

import java.io.FileReader;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.io.InputStream;
import java.io.FileInputStream;

public class ReadIssuerFromCertificate {
    public static void main(String[] args) {
        X509Certificate cert = null;
        try (InputStream inStream = new FileInputStream("/path/to/certificate.pem")) {
            CertificateFactory cf = CertificateFactory.getInstance("X.509");
            cert = (X509Certificate) cf.generateCertificate(inStream);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (cert != null) {
            X500Name issuer = X500Name.getInstance(cert.getIssuerX500Principal().getEncoded());
            System.out.println("Issuer: " + issuer);
        }
    }
}