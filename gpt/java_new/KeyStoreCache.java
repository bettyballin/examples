import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

public class KeyStoreCache {
    private byte[] keyStoreBytes;

    public void loadKeyStoreToMemory(String keyStorePath, char[] keyStorePassword)
            throws IOException, CertificateException, NoSuchAlgorithmException {
        keyStoreBytes = Files.readAllBytes(Paths.get(keyStorePath));
        // Load and initialize the KeyStore to ensure
        try (InputStream keyStoreStream = new ByteArrayInputStream(keyStoreBytes)) {
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(keyStoreStream, keyStorePassword);
        } catch (Exception e) {
            throw new IOException("Failed to load keystore", e);
        }
    }
}