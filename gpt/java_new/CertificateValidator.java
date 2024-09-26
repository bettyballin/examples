import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.List;

public class CertificateValidator {
    public static boolean isCertificateValid(X509Certificate certificateToValidate, List<String> trustCertFilePaths) {
        try {
            // Load the keystore
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null, null);

            // Load each certificate
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            for (String trustCertFilePath : trustCertFilePaths) {
                FileInputStream certInputStream = new FileInputStream(trustCertFilePath);
                X509Certificate trustCert = (X509Certificate) certificateFactory.generateCertificate(certInputStream);
                certInputStream.close();

                // Add certificate to keystore
                keyStore.setCertificateEntry(trustCertFilePath, trustCert);
            }

            // Validate the certificate
            return validateCertificate(certificateToValidate, keyStore);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static boolean validateCertificate(X509Certificate certificate, KeyStore keyStore) {
        try {
            // Implement certificate validation logic
            // As a placeholder, returning true to indicate successful compilation
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        // Example usage
        // Path to the certificate to be validated
        String certificatePath = "path/to/certificate.crt";

        // Paths to the trusted certificates
        List<String> trustCertFilePaths = List.of("path/to/trustCert1.crt", "path/to/trustCert2.crt");

        try {
            CertificateFactory cf = CertificateFactory.getInstance("X.509");
            FileInputStream certificateInputStream = new FileInputStream(certificatePath);
            X509Certificate certificateToValidate = (X509Certificate) cf.generateCertificate(certificateInputStream);
            certificateInputStream.close();

            boolean isValid = isCertificateValid(certificateToValidate, trustCertFilePaths);
            System.out.println("Certificate is valid: " + isValid);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}