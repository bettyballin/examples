import java.io.File;
import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.KeyStore.PrivateKeyEntry;
import java.security.KeyStore.Entry;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.util.Enumeration;

public class Temp605 {
    public static void main(String[] args) {
        try {
            String p12Path = "path_to_your_p12_file.p12"; // Set the path to your .p12 file
            char[] p12Password = "your_password".toCharArray(); // Set your .p12 password

            KeyStore ks = KeyStore.getInstance("pkcs12");
            ks.load(new FileInputStream(new File(p12Path)), p12Password);

            Enumeration<String> aliases = ks.aliases();

            PrivateKey p12Key = null;
            Certificate[] p12Chain = null;

            while (aliases.hasMoreElements()) {
                String alias = aliases.nextElement();
                Entry entry = ks.getEntry(alias, new KeyStore.PasswordProtection(p12Password));

                if (entry instanceof PrivateKeyEntry) {
                    // This is a keypair
                    PrivateKeyEntry privateKeyEntry = (PrivateKeyEntry) entry;

                    p12Key = privateKeyEntry.getPrivateKey();
                    p12Chain = privateKeyEntry.getCertificateChain();
                } else {
                    // This is not a keypair, it's just a certificate or chain.
                }
            }

            // Print out the private key and certificate chain for verification
            if (p12Key != null) {
                System.out.println("Private Key: " + p12Key.toString());
            }

            if (p12Chain != null) {
                System.out.println("Certificate Chain:");
                for (Certificate certificate : p12Chain) {
                    System.out.println(certificate.toString());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}