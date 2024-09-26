import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.openssl.PEMParser;
import java.io.FileReader;
import java.io.IOException;

public class CertificateLoader2 {
    public static void main(String[] args) {
        PEMParser pemParser = null;
        try {
            pemParser = new PEMParser(new FileReader("src/main/resources/cacert.crt"));
            X509CertificateHolder caCertificate = (X509CertificateHolder) pemParser.readObject();
            // Do something with caCertificate
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (pemParser != null) {
                try {
                    pemParser.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}