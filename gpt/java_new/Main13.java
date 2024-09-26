import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.util.Base64;

public class Main13 {
    public static void main(String[] args) {
        try {
            KeyStore keystore = KeyStore.getInstance("PKCS12");
            try (FileInputStream fis = new FileInputStream("path/to/keystore.p12")) {
                keystore.load(fis, "keystorePassword".toCharArray());
            }
            Certificate cert = keystore.getCertificate("alias");
            byte[] certBytes = cert.getEncoded();
            String encodedCert = Base64.getEncoder().encodeToString(certBytes);
            System.out.println(encodedCert);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}