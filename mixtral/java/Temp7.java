import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;

public class Temp7 {
    public static void main(String[] args) throws Exception {
        KeyStore keyStore = KeyStore.getInstance("Windows-MY");
        keyStore.load(null);

        String alias = (String) keyStore.aliases().nextElement();
        PrivateKey privateKey = (PrivateKey) keyStore.getKey(alias, null);
        X509Certificate cert = (X509Certificate) keyStore.getCertificate(alias);

        System.out.println("Alias: " + alias);
        System.out.println("Private Key: " + privateKey);
        System.out.println("Certificate: " + cert);
    }
}