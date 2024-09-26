import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.openssl.PEMParser;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try (PEMParser pemParser = new PEMParser(new FileReader("src/main/resources/cacert.crt"))) {
            X509CertificateHolder caCertificate = (X509CertificateHolder) pemParser.readObject();
            System.out.println(caCertificate);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}