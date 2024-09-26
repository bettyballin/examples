import javax.crypto.Cipher;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableEntryException;
import java.security.cert.CertificateException;
import java.io.IOException;

public class Temp1505 {
    public static void main(String[] args) {
        try {
            // Initialize KeyStore
            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(null, null); // Load your keystore properly here

            // Retrieve the private key entry
            KeyStore.ProtectionParameter protParam = new KeyStore.PasswordProtection("password".toCharArray());
            KeyStore.PrivateKeyEntry privateKeyEntry = (KeyStore.PrivateKeyEntry) keyStore.getEntry("alias", protParam);

            // Initialize Cipher
            Cipher output = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            output.init(Cipher.DECRYPT_MODE, privateKeyEntry.getPrivateKey());

            // Add your decryption logic here

        } catch (KeyStoreException | NoSuchAlgorithmException | UnrecoverableEntryException | CertificateException | IOException | javax.crypto.NoSuchPaddingException | java.security.InvalidKeyException e) {
            e.printStackTrace();
        }
    }
}