import java.security.MessageDigest;
import java.security.cert.X509Certificate;
import java.security.cert.CertificateFactory;
import java.io.InputStream;
import java.io.FileInputStream;

public class CertificateFingerprint {
    public static void main(String[] args) {
        try {
            // Load certificate from file
            InputStream inStream = new FileInputStream("path_to_certificate");
            CertificateFactory cf = CertificateFactory.getInstance("X.509");
            X509Certificate cert = (X509Certificate) cf.generateCertificate(inStream);
            inStream.close();

            // Calculate MD5 fingerprint
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] fingerprint = md.digest(cert.getEncoded());

            // Convert to hex string
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < fingerprint.length; i++) {
                sb.append(String.format("%02X", fingerprint[i]));
                if (i < fingerprint.length - 1) {
                    sb.append(":");
                }
            }
            String md5Fingerprint = sb.toString();

            System.out.println("MD5 Fingerprint: " + md5Fingerprint);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}