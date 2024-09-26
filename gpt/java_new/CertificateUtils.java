import java.util.Base64;
import java.security.cert.Certificate;

public class CertificateUtils {

    private static byte[] certificate;

    public static void initializeCertificate(Certificate cert) throws Exception {
        certificate = cert.getEncoded(); // Get the encoded form of the certificate
    }

    public static String getCertificateString() {
        // Ensure that the 'certificate' byte array contains the actual byte representation of the certificate
        return Base64.getEncoder().encodeToString(certificate);
    }
}