import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.PublicKey;
import java.security.cert.X509Certificate;
import java.util.Enumeration;

public class RSAPublicKeyExtractor {

    public static void main(String[] args) throws Exception {
        String pfxFilePath = "path/to/your/file.pfx"; // Replace with your PFX file path
        String password = "your_password"; // Replace with your PFX password

        FileInputStream fis = new FileInputStream(pfxFilePath);
        KeyStore keyStore = KeyStore.getInstance("PKCS12");
        keyStore.load(fis, password.toCharArray());
        fis.close();

        Enumeration<String> aliases = keyStore.aliases();
        while (aliases.hasMoreElements()) {
            String alias = aliases.nextElement();
            if (keyStore.isKeyEntry(alias)) {
                X509Certificate certificate = (X509Certificate) keyStore.getCertificate(alias);
                PublicKey publicKey = certificate.getPublicKey();
                System.out.println("Public Key for alias " + alias + ": " + publicKey.toString());
            }
        }
    }
}