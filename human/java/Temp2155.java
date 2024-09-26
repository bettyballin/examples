import com.itextpdf.text.pdf.PdfReader;
import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

public class Temp2155 {
    public static void main(String[] args) {
        try {
            String src = "path/to/your/pdf.pdf"; // Replace with the path to your PDF file
            X509Certificate certificate = getPublicCertificate("C:\\Users\\USER\\Documents\\NetBeansProjects\\test\\src\\lk_encb64.cer");
            PrivateKey privateKey = getPrivateKey();
            PdfReader reader = new PdfReader(src, certificate, privateKey, "SunPKCS11-eToken");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static X509Certificate getPublicCertificate(String certificatePath) throws Exception {
        FileInputStream fis = new FileInputStream(certificatePath);
        CertificateFactory cf = CertificateFactory.getInstance("X.509");
        return (X509Certificate) cf.generateCertificate(fis);
    }

    private static PrivateKey getPrivateKey() throws Exception {
        // Replace with the path to your keystore file and the appropriate password
        String keystorePath = "path/to/your/keystore.p12";
        String keystorePassword = "your_keystore_password";
        String keyAlias = "your_key_alias";
        String keyPassword = "your_key_password";

        FileInputStream fis = new FileInputStream(keystorePath);
        KeyStore keystore = KeyStore.getInstance("PKCS12");
        keystore.load(fis, keystorePassword.toCharArray());
        return (PrivateKey) keystore.getKey(keyAlias, keyPassword.toCharArray());
    }
}