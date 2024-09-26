import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

public class DERtoPEM {
    public static void main(String[] args) {
        try {
            // Replace with your DER-encoded filename
            String derFileName = "example.der";
            String pemFileName = "example.pem";

            // Read DER file
            FileInputStream derInputStream = new FileInputStream(derFileName);
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            X509Certificate cert = (X509Certificate) certificateFactory.generateCertificate(derInputStream);
            derInputStream.close();

            // Convert to PEM
            StringWriter pemStringWriter = new StringWriter();
            try (JcaPEMWriter pemWriter = new JcaPEMWriter(pemStringWriter)) {
                pemWriter.writeObject(cert);
            }

            // Write PEM to file
            try (FileWriter pemFileWriter = new FileWriter(pemFileName)) {
                pemFileWriter.write(pemStringWriter.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}