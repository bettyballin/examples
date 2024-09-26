import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.Certificate;
import java.util.Enumeration;

public class CertificateUtil {

    public static Certificate[] getCertificateChainForAlias(KeyStore keystore, String alias) throws KeyStoreException {
        return keystore.getCertificateChain(alias);
    }

    public static void main(String[] args) {
        try {
            KeyStore keystore = KeyStore.getInstance("Windows-MY");
            keystore.load(null, null);
            Enumeration<String> aliases = keystore.aliases();

            while (aliases.hasMoreElements()) {
                String alias = aliases.nextElement();
                Certificate[] certificateChain = getCertificateChainForAlias(keystore, alias);

                if (certificateChain != null) {
                    // Process the certificate chain
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}