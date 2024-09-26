import java.io.FileInputStream;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;

public class RefactoredSnippet {
    public static void main(String[] args) throws Exception {
        KeyStore keyStore = KeyStore.getInstance("PKCS12");
        try (InputStream keyInputStream = new FileInputStream("/path/to/yourcertificate.p12")) {
            keyStore.load(keyInputStream, "password".toCharArray());
        }
        PrivateKey privateKey = (PrivateKey) keyStore.getKey("alias", "password".toCharArray());
        X509Certificate certificate = (X509Certificate) keyStore.getCertificate("alias");
        
        // Use the privateKey and certificate as needed
    }
}