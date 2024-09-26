import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

public class Temp1522 {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("path_to_your_pfx_file.pfx")) {
            KeyStore pkcs12 = KeyStore.getInstance("PKCS12");
            pkcs12.load(fis, "your_password".toCharArray());
        } catch (KeyStoreException | IOException | NoSuchAlgorithmException | CertificateException e) {
            e.printStackTrace();
        }
    }
}