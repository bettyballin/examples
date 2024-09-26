import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.io.InputStream;
import java.io.FileInputStream;
import java.security.cert.CertPath;
import java.security.cert.CertificateException;
import java.util.Arrays;

public class CertificateVerifier {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Usage: CertificateVerifier <CA certificate> <certificate to verify>");
            return;
        }

        String caCertificatePath = args[0];
        String certificateToVerifyPath = args[1];

        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");

            // Load the CA certificate
            InputStream caInputStream = new FileInputStream(caCertificatePath);
            X509Certificate caCertificate = (X509Certificate) certificateFactory.generateCertificate(caInputStream);
            caInputStream.close();

            // Load the certificate to be verified
            InputStream certificateInputStream = new FileInputStream(certificateToVerifyPath);
            X509Certificate certificateToVerify = (X509Certificate) certificateFactory.generateCertificate(certificateInputStream);
            certificateInputStream.close();

            // Verify the certificate
            certificateToVerify.verify(caCertificate.getPublicKey());

            System.out.println("The certificate is valid.");
        } catch (CertificateException | java.security.NoSuchAlgorithmException | java.security.InvalidKeyException | java.security.NoSuchProviderException | java.security.SignatureException | java.io.IOException e) {
            System.err.println("The certificate is invalid: " + e.getMessage());
        }
    }
}