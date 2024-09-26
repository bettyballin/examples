import java.io.FileInputStream;
import java.security.Key;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.util.Enumeration;

public class KeyStoreLoader1 {

    public void loadKeyStore(String p12Path, String p12Password) throws Exception {
        KeyStore ks = KeyStore.getInstance("PKCS12");
        ks.load(new FileInputStream(p12Path), p12Password.toCharArray());

        Enumeration<String> aliases = ks.aliases();
        while (aliases.hasMoreElements()) {
            String alias = aliases.nextElement();
            if (ks.isKeyEntry(alias)) {
                Key key = ks.getKey(alias, p12Password.toCharArray());
                Certificate[] chain = ks.getCertificateChain(alias);
                // Use the key and chain as needed
            }
        }
    }
}