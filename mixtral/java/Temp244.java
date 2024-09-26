import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.cert.X509Certificate;

public class Temp244 {
    public static void main(String[] args) {
        try {
            KeyStore ks = KeyStore.getInstance("PKCS12");
            ks.load(new FileInputStream("D://validcertFormCa.pfx"), "password".toCharArray());
            X509Certificate masterCert = (X509Certificate) ks.getCertificate("aliasOfTheKeyInKeystore");
            System.out.println(masterCert);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}