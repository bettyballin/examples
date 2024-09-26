import java.io.FileInputStream;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.Key;

public class PublicKeyConverter {
    public static byte[] getPublicKeyBlob() throws Exception {
        // Load the X509 certificate from a file
        CertificateFactory cf = CertificateFactory.getInstance("X.509");
        FileInputStream fis = new FileInputStream("path/to/certificate.cer");
        X509Certificate cert = (X509Certificate) cf.generateCertificate(fis);
        
        // Get the public key from the certificate
        byte[] publicKeyBlob = cert.getPublicKey().getEncoded();
        
        // Close the file input stream
        fis.close();
        
        return publicKeyBlob;
    }
    
    public static void main(String[] args) {
        try {
            byte[] publicKeyBlob = getPublicKeyBlob();
            System.out.println(java.util.Arrays.toString(publicKeyBlob));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}