import javax.servlet.http.HttpServletRequest;
import java.security.cert.X509Certificate;

public class CertificateExtractor {

    public void extractCertificate(HttpServletRequest request) {
        Object certChain = request.getAttribute("javax.servlet.request.X509Certificate");
        if (certChain instanceof X509Certificate[]) {
            X509Certificate[] certs = (X509Certificate[]) certChain;
            if(certs.length > 0) {
                X509Certificate cert = certs[0];
                String n = cert.getSubjectDN().getName();
                // Process the certificate subject name 'n' as needed
            }
        }
    }
}