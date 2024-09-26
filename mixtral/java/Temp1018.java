import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyStore;

public class Temp1018 {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("./keys");
            KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
            String password = "your_password"; // Replace with your actual password
            ks.load(fis, password.toCharArray());
            fis.close();
        } catch (IOException | java.security.KeyStoreException | java.security.NoSuchAlgorithmException | java.security.cert.CertificateException e) {
            e.printStackTrace();
        }
    }
}