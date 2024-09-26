import java.security.cert.X509Certificate;

public class CertificateSnippet {
    public static void main(String[] args) {
        X509Certificate certificate = /* retrieve or initialize certificate */;
        String issuerName = certificate.getIssuerX500Principal().getName();
        System.out.println(issuerName);
    }
}