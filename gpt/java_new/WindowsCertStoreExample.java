import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;

public class WindowsCertStoreExample {
    public static void main(String[] args) {
        try {
            KeyStore ks = KeyStore.getInstance("Windows-MY", "SunMSCAPI");
            ks.load(null, null);

            String alias = "myCertificateAlias";

            if (ks.containsAlias(alias)) {
                Certificate cert = ks.getCertificate(alias);
                if (cert instanceof X509Certificate) {
                    X509Certificate x509cert = (X509Certificate) cert;
                    System.out.println("Certificate: " + x509cert.toString());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}