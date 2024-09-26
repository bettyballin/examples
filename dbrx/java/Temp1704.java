import java.io.FileInputStream;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public class Temp1704 {
    public static void main(String[] args) {
        try {
            KeyStore ks = KeyStore.getInstance("JKS");
            try (InputStream in = new FileInputStream("/path/to/your/truststore.jks")) {
                char[] password = "truststore_password".toCharArray();
                ks.load(in, password);
            }

            TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            tmf.init(ks);

            X509TrustManager trustManager = (X509TrustManager) tmf.getTrustManagers()[0];

            CertificateFactory cf = CertificateFactory.getInstance("X.509");
            try (InputStream in2 = new FileInputStream("/path/to/your/end-entity-cert.pem")) {
                X509Certificate targetCert = (X509Certificate) cf.generateCertificate(in2);
                X509Certificate[] acceptedIssuers = trustManager.getAcceptedIssuers();
                if (acceptedIssuers != null && acceptedIssuers.length > 0) {
                    targetCert.verify(acceptedIssuers[0].getPublicKey());
                    System.out.println("Certificate verification succeeded.");
                } else {
                    System.out.println("No accepted issuers found in truststore.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Certificate verification failed.");
        }
    }
}