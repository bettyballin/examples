import java.security.KeyStore;
import java.security.cert.Certificate;
import java.io.FileInputStream;
import java.util.Enumeration;
import java.util.List;
import java.util.ArrayList;

public class Temp28 {
    public static void main(String[] args) {
        try {
            // Assuming the keystore is already loaded
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            // Load the keystore from a file or other source (this is just an example)
            keyStore.load(new FileInputStream("keystore.jks"), "keystorePassword".toCharArray());

            // Retrieve the list of aliases (i.e certificate names) in the keystore
            Enumeration<String> aliasesEnum = keyStore.aliases();
            List<String> aliases = new ArrayList<>();
            while (aliasesEnum.hasMoreElements()) {
                aliases.add(aliasesEnum.nextElement());
            }

            // Iterate over each alias and retrieve its password (assuming passwords are the same)
            for (String alias : aliases) {
                char[] entryPassword = "entryPassword".toCharArray(); // replace with actual password retrieval logic

                // Use the entry password to access the certificate
                KeyStore.ProtectionParameter protParam = new KeyStore.PasswordProtection(entryPassword);
                KeyStore.PrivateKeyEntry ke = (KeyStore.PrivateKeyEntry) keyStore.getEntry(alias, protParam);
                Certificate cert = ke.getCertificate();

                // Do something with the certificate
                System.out.println(cert);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}