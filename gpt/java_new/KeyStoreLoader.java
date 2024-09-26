import java.io.FileInputStream;
import java.security.Key;
import java.security.KeyStore;
import java.util.Enumeration;

public class KeyStoreLoader {
    public static void main(String[] args) throws Exception {
        char[] password = "pfx-password".toCharArray();
        KeyStore keystore = KeyStore.getInstance("PKCS12");
        try (FileInputStream fis = new FileInputStream("path/to/your/pfx-file.pfx")) {
            keystore.load(fis, password);
        }

        Enumeration<String> aliases = keystore.aliases();
        if (aliases.hasMoreElements()) {
            String alias = aliases.nextElement();
            Key key = keystore.getKey(alias, password);
            // Use the key for your purposes
        }
    }
}