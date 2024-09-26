import java.io.FileInputStream;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

public class Temp974 {
    public static void main(String[] args) {
        try {
            KeyStore truststore = KeyStore.getInstance("JKS");
            truststore.load(null, null);

            CertificateFactory cf = CertificateFactory.getInstance("X509");
            InputStream caInput = new FileInputStream("/path/to/your/certfile.crt");

            // You can add multiple certificates here
            while (caInput.available() > 0) {
                X509Certificate certificate = (X509Certificate) cf.generateCertificate(caInput);
                truststore.setCertificateEntry("alias", certificate);
            }

            caInput.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}