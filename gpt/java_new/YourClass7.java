import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;

public class YourClass7 {
    public void yourMethod(String signCertName, char[] passphrase) throws Exception {
        CertificateFactory cf = CertificateFactory.getInstance("X.509");
        String SEP = File.separator;
        String pack = "/path/to/certificate/folder/";

        // Load the keystore
        File file = new File(new File(System.getProperty("java.home"), "lib" + SEP + "security"), "cacerts");
        KeyStore keystore;
        try (FileInputStream javaCertIn = new FileInputStream(file)) {
            keystore = KeyStore.getInstance(KeyStore.getDefaultType());
            keystore.load(javaCertIn, passphrase);
        }

        // Import the sign certificate if it doesn't exist in the keystore
        if (!keystore.containsAlias(signCertName)) {
            try (InputStream signCertIn = ClassLoader.getSystemResourceAsStream(pack + signCertName + ".cer")) {
                Certificate cert = cf.generateCertificate(signCertIn);
                keystore.setCertificateEntry(signCertName, cert);
            }
        }
    }
}