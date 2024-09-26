import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.Collection;

public class Temp255 {
    public static void main(String[] args) {
        try {
            String certStr = "-----BEGIN CERTIFICATE-----\n" +
                    "MIID...Qg==\n" +
                    "-----END CERTIFICATE-----";
            CertificateFactory cf = CertificateFactory.getInstance("X.509");
            InputStream is = new ByteArrayInputStream(certStr.getBytes(StandardCharsets.UTF_8));
            Certificate cert = cf.generateCertificate(is);
            System.out.println("Certificate: " + cert);
        } catch (CertificateException e) {
            e.printStackTrace();
        }
    }
}