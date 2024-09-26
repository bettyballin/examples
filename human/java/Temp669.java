import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import javax.crypto.spec.SecretKeySpec;

public class Temp669 {

    private KeyStore mKeystore;
    private String mKeyStoreName;
    private String mKeystoreDirectoryPath;
    private String mKeyStorePassword;
    private static final String TAG = "Temp669";

    public static void main(String[] args) {
        Temp669 temp = new Temp669();
        temp.init();
        boolean result = temp.setEntry("alias", "secretKey");
        System.out.println("Result: " + result);
    }

    public void init() {
        try {
            mKeystore = KeyStore.getInstance(KeyStore.getDefaultType());
            mKeyStoreName = "keystore.jks";
            mKeystoreDirectoryPath = "./";
            mKeyStorePassword = "password";
            mKeystore.load(null, mKeyStorePassword.toCharArray());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean setEntry(String alias, String secretKey) {

        boolean keyStoreEntryWritten = false;

        if (mKeystore != null && secretKey != null) {
            // store something in the key store
            SecretKeySpec sks = new SecretKeySpec(secretKey.getBytes(), "AES");
            KeyStore.SecretKeyEntry ske = new KeyStore.SecretKeyEntry(sks);
            KeyStore.ProtectionParameter pp = new KeyStore.PasswordProtection(null);

            try {
                mKeystore.setEntry(alias, ske, pp);

                // save key store
                boolean success = saveKeyStore();

                if (success) {
                    keyStoreEntryWritten = true;
                }
            } catch (KeyStoreException ex) {
                System.err.println("Failed to read keystore " + mKeyStoreName);
            }
        }
        return keyStoreEntryWritten;
    }

    private boolean saveKeyStore() {

        FileOutputStream fos = null;
        boolean keyStoreSaved = true;

        // generate key store path
        String keyStoreFilePath = generateKeyStoreFilePath(mKeyStoreName, mKeystoreDirectoryPath);

        try {
            fos = new FileOutputStream(keyStoreFilePath);
            mKeystore.store(fos, mKeyStorePassword.toCharArray());
        } catch (Exception ex) {
            keyStoreSaved = false;
            System.err.println("Failed to save keystore " + mKeyStoreName);
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException ex) {
                    keyStoreSaved = false;
                    System.err.println("Failed to close FileOutputStream");
                }
            }
        }
        return keyStoreSaved;
    }

    private String generateKeyStoreFilePath(String keyStoreName, String keystoreDirectoryPath) {
        return keystoreDirectoryPath + keyStoreName;
    }

}