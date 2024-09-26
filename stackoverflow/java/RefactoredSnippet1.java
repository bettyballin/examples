import java.io.FileInputStream;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class RefactoredSnippet1 {
    public static void main(String[] args) throws Exception {
        KeyStore ks = KeyStore.getInstance("BKS");
        try (InputStream is = new FileInputStream("/etc/security/cacerts.bks")) {
            ks.load(is, "changeit".toCharArray());
        }

        List<X509Certificate> certs = new ArrayList<>();
        Enumeration<String> aliases = ks.aliases();
        while (aliases.hasMoreElements()) {
            String alias = aliases.nextElement();
            X509Certificate cert = (X509Certificate) ks.getCertificate(alias);
            if (cert != null) {
                certs.add(cert);
            }
        }
        // rest of the code that uses certs
    }
}