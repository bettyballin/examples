import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;

public class Temp3 {
    public static void main(String[] args) throws Exception {
        // ...

        String keyAlias = "your-certificate-alias";
        char[] password = null; // or your certificate password

        KeyStore ks = KeyStore.getInstance("Windows-MY");
        ks.load(null);

        PrivateKey privateKey = (PrivateKey) ks.getKey(keyAlias, password);
        X509Certificate cert = (X509Certificate) ks.getCertificate(keyAlias);

        // For demonstration purposes, print some details
        System.out.println("Private Key: " + privateKey);
        System.out.println("Certificate: " + cert);
    }
}