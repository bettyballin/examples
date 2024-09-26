import javax.servlet.http.HttpServletRequest;
import java.security.cert.X509Certificate;

public class CertificateExtractor {

    public void extractUserInformation(HttpServletRequest request) {
        X509Certificate[] certificates = (X509Certificate[]) request.getAttribute("javax.servlet.request.X509Certificate");
        if (certificates != null && certificates.length > 0) {
            X509Certificate cert = certificates[0];
            // Extract user information from the certificate
            String commonName = getCommonName(cert);
            String email = getEmail(cert);
            // ... other methods to extract info as needed
        }
    }

    private String getCommonName(X509Certificate cert) {
        // Implement extraction of the common name from the certificate
        return ""; // Placeholder return value
    }

    private String getEmail(X509Certificate cert) {
        // Implement extraction of the email from the certificate
        return ""; // Placeholder return value
    }

    // ... other helper methods for extraction
}