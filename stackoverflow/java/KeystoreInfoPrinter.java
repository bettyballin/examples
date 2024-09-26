import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.interfaces.RSAPublicKey;
import java.util.Enumeration;

public class KeystoreInfoPrinter {
    public static void main(String[] args) throws Exception {
        String file = "your_keystore_file.p12"; // Replace with actual file path
        char[] password = "your_keystore_password".toCharArray(); // Replace with actual password

        KeyStore ks = KeyStore.getInstance("pkcs12");
        ks.load(new FileInputStream(file), password);
        Enumeration<String> enumeration = ks.aliases();
        while (enumeration.hasMoreElements()) {
            String alias = enumeration.nextElement();
            Certificate certificate = ks.getCertificate(alias);
            if (certificate.getPublicKey() instanceof RSAPublicKey) {
                RSAPublicKey pub = (RSAPublicKey) certificate.getPublicKey();
                System.out.println(pub.getModulus().toString(16));
                System.out.println(pub.getPublicExponent().toString(16));
            }
        }
    }
}