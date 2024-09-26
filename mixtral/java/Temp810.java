import java.security.KeyStore;
import java.security.cert.X509Certificate;
import java.util.Enumeration;

public class Temp810 {
    public static void main(String[] args) {
        try {
            // Load the keystore
            KeyStore ks = KeyStore.getInstance("JKS");
            ks.load(null, null); // Load the keystore with your parameters

            // Example password, replace with your actual password
            char[] p12Password = "password".toCharArray();

            // Get aliases enumeration
            Enumeration<String> aliasEnum = ks.aliases();

            while (aliasEnum.hasMoreElements()) {
                String alias = aliasEnum.nextElement();

                if (ks.getEntry(alias, null) instanceof KeyStore.PrivateKeyEntry) {
                    // This is a key pair
                    java.security.Key p12Key = ks.getKey(alias, p12Password);
                    java.security.cert.Certificate[] p12Chain = ks.getCertificateChain(alias);

                    // Do something with the key and chain
                } else if (ks.getEntry(alias, null) instanceof KeyStore.TrustedCertificateEntry) {
                    // This is a trusted certificate
                    X509Certificate cert = (X509Certificate) ks.getCertificate(alias);

                    // Do something with the certificate
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}