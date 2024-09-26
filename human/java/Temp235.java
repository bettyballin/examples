import java.io.FileInputStream;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class Temp235 {
    public static void main(String[] args) {
        try {
            KeyStore ks = KeyStore.getInstance("BKS");
            InputStream is = new FileInputStream("/etc/security/cacerts.bks");
            ks.load(is, "changeit".toCharArray());

            List<X509Certificate> certs = new ArrayList<X509Certificate>();
            Enumeration<String> aliases = ks.aliases();
            while (aliases.hasMoreElements()) {
                String alias = aliases.nextElement();
                X509Certificate cert = (X509Certificate) ks.getCertificate(alias);
                certs.add(cert);
            }

            // Add logic to handle the certificates if needed
            for (X509Certificate cert : certs) {
                System.out.println(cert.getSubjectDN());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}