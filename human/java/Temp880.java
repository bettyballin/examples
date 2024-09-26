import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.interfaces.RSAPublicKey;
import java.util.Enumeration;

public class Temp880 {
    public static void main(String[] args) {
        try {
            String file = "path/to/keystore.p12"; // Specify the keystore file path
            String password = "your_keystore_password"; // Specify the keystore password

            KeyStore ks = KeyStore.getInstance("pkcs12");
            ks.load(new FileInputStream(file), password.toCharArray());
            Enumeration<String> enumeration = ks.aliases();
            while (enumeration.hasMoreElements()) {
                String alias = enumeration.nextElement();
                Certificate certificate = ks.getCertificate(alias);
                RSAPublicKey pub = (RSAPublicKey) certificate.getPublicKey();
                System.out.println(pub.getModulus().toString(16));
                System.out.println(pub.getPublicExponent().toString(16));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}