import javax.security.auth.x500.X500Principal;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

public class Temp867 {
    private static final String[] TRUSTED_CERTIFICATES_PATHS = {"path/to/cert1.pem", "path/to/cert2.pem"};

    public static void main(String[] args) {
        try {
            Set<X500Principal> caPrincipals = new HashSet<>();
            for (String certificatePath : TRUSTED_CERTIFICATES_PATHS) {
                CertificateFactory cf = CertificateFactory.getInstance("X.509");
                InputStream certInputStream = new FileInputStream(certificatePath);
                X509Certificate caCert = (X509Certificate) cf.generateCertificate(certInputStream);
                caPrincipals.add(caCert.getSubjectX500Principal());
                certInputStream.close();
            }

            // Printing the results for verification
            for (X500Principal principal : caPrincipals) {
                System.out.println(principal);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}