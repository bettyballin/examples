import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.cert.CertificateFactory;
import java.security.cert.X509CertSelector;

public class CertificateVerification {

    public static void main(String[] args) throws Exception {
        // Load the CA's root certificate or intermediate certificates (if any)
        KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        FileInputStream fis = new FileInputStream("path/to/keystore.jks");
        char[] password = "password".toCharArray();
        keyStore.load(fis, password);

        X509CertSelector certSelector = new X509CertSelector();
        // Set the certificate to be verified
        CertificateFactory cf = CertificateFactory.getInstance("X.509");
        FileInputStream fr  = new FileInputStream("path/to/certificate.cer");
        java.security.cert.X509Certificate c = (java.security.cert.X509Certificate)
                cf.generateCertificate(fr);
        certSelector.setSubject(c.getSubjectDN().getName()); // Corrected here

        // Verify the certificate
        java.security.cert.Certificate[] chain = keyStore.getCertificateChain(c.getIssuerDN().getName());
        if (chain == null) {
            System.out.println("Certificate not trusted");
        } else {
            System.out.println("Certificate trusted");
        }
    }
}