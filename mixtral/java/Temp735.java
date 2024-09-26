import java.security.cert.X509CRL;
import java.security.cert.X509Certificate;
import java.security.cert.CertificateFactory;
import java.io.FileInputStream;

public class Temp735 {
    public static void main(String[] args) {
        try {
            // Load the CRL from a file
            FileInputStream fis = new FileInputStream("path/to/crl/file.crl");
            CertificateFactory cf = CertificateFactory.getInstance("X.509");
            X509CRL crl = (X509CRL) cf.generateCRL(fis);

            // Load the certificate to check from a file
            FileInputStream fisCert = new FileInputStream("path/to/certificate/file.crt");
            X509Certificate cert = (X509Certificate) cf.generateCertificate(fisCert);

            // Check if the certificate is revoked
            if (crl.isRevoked(cert)) {
                System.out.println("revoked");
            } else {
                System.out.println("not revoked");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}