import org.bouncycastle.cert.CertificateException;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openssl.PEMParser;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.security.Security;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.CertificateRevokedException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

public class Temp379 {
    public static void main(String[] args) throws Exception {
        Security.addProvider(new BouncyCastleProvider());

        // Load the custom root CA list from memory
        List<X509Certificate> trustStore = new ArrayList<>();
        trustStore.add(loadCertificate("path/to/rootCA1.cer"));
        trustStore.add(loadCertificate("path/to/rootCA2.cer"));

        // Load certificate to be validated
        X509Certificate certificate = loadCertificate("path/to/certificate.cer");

        // Validate the certificate chain
        try {
            certificate.checkValidity();
            boolean isValid = validateCertificate(certificate, trustStore);
            if (isValid) {
                System.out.println("The certificate is valid.");
            } else {
                System.out.println("The certificate is not valid.");
            }
        } catch (CertificateNotYetValidException | CertificateRevokedException e) {
            System.out.println("The certificate is not valid: " + e.getMessage());
        }
    }

    public static X509Certificate loadCertificate(String path) throws IOException, CertificateException {
        try (FileInputStream fis = new FileInputStream(path)) {
            CertificateFactory cf = CertificateFactory.getInstance("X.509");
            return (X509Certificate) cf.generateCertificate(fis);
        }
    }

    public static boolean validateCertificate(X509Certificate certificate, List<X509Certificate> trustStore) {
        for (X509Certificate rootCA : trustStore) {
            try {
                certificate.verify(rootCA.getPublicKey());
                return true;
            } catch (Exception e) {
                // Verification failed, continue with the next root CA
            }
        }
        return false;
    }
}
class CertificateException extends Exception {}
class CertificateNotYetValidException extends CertificateException {}
class CertificateRevokedException extends CertificateException {}