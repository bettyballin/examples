import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;

public class KeyStoreExample {
    public static void main(String[] args) {
        try {
            String signCertPath = "path/to/your/signing_cert";
            String signCertName = "signCertName";
            String sslCertPath = "path/to/your/ssl_cert";
            String sslCertName = "sslCertName";
            String passphrase = "your_passphrase";
            String pack = "your_package/";

            KeyStore signKeys = KeyStore.getInstance(KeyStore.getDefaultType());
            signKeys.load(new FileInputStream(signCertPath), passphrase.toCharArray());

            if (!signKeys.containsAlias(signCertName)) {
                CertificateFactory cf = CertificateFactory.getInstance("X.509");
                Certificate cert = cf.generateCertificate(ClassLoader.getSystemResourceAsStream(pack + signCertName + ".cer"));
                signKeys.setCertificateEntry(signCertName, cert);
            }

            KeyStore sslKeys = KeyStore.getInstance(KeyStore.getDefaultType());
            sslKeys.load(new FileInputStream(sslCertPath), passphrase.toCharArray());

            if (!sslKeys.containsAlias(sslCertName)) {
                CertificateFactory cf = CertificateFactory.getInstance("X.509");
                Certificate cert = cf.generateCertificate(ClassLoader.getSystemResourceAsStream(pack + sslCertName + ".crt"));
                sslKeys.setCertificateEntry(sslCertName, cert);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}