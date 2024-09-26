import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

public class Temp120 {
    public static void main(String[] args) {
        try {
            // Load the certificate from a file
            InputStream inStream = new FileInputStream("path/to/cert.pem");
            CertificateFactory cf = CertificateFactory.getInstance("X.509");
            X509Certificate cert = (X509Certificate) cf.generateCertificate(inStream);
            inStream.close();

            // Calculate MD5 fingerprint
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(cert.getEncoded());
            byte[] md5Fingerprint = md5.digest();

            // Get SubjectKeyIdentifier
            byte[] subjectKeyId = cert.getExtensionValue("2.5.29.14"); // OID for Subject Key Identifier

            System.out.println("MD5 Fingerprint: " + toHexString(md5Fingerprint));
            System.out.println("SubjectKeyIdentifier: " + toHexString(subjectKeyId));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Helper method to convert a byte array to a hex string
    static String toHexString(byte[] bytes) {
        StringBuilder hex = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            hex.append(String.format("%02X", bytes[i]));
        }
        return hex.toString();
    }
}