import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

public class Temp1411 {
    private static final String JKS_PRIVATE_FILE_NAME = "keystore.jks";
    private static final String KEYSTORE_TYPE = "JKS";
    private static final char[] PASSWORD = "password".toCharArray();

    public static void main(String[] args) {
        String alias = "myAlias";
        try {
            KeyStore keyStore = KeyStore.getInstance(KEYSTORE_TYPE);
            keyStore.load(null, PASSWORD);

            try (FileOutputStream out = new FileOutputStream(new File(JKS_PRIVATE_FILE_NAME))) {
                keyStore.store(out, PASSWORD);
                System.out.println("Alias exists = " + keyStore.containsAlias(alias));
            }
        } catch (KeyStoreException | NoSuchAlgorithmException | CertificateException | IOException e) {
            e.printStackTrace();
        }
    }
}