import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.KeyStore;

public class ChangeKeyStorePassword {
    public static void main(String[] args) {
        String keyStoreFileName = "mykeystore.jks"; // Replace with your keystore file name
        char[] oldPassword = "oldpassword".toCharArray(); // Replace with your old password
        char[] newPassword = "newpassword".toCharArray(); // Replace with your new password

        try {
            // Load the keystore
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            try (InputStream keyStoreData = new FileInputStream(keyStoreFileName)) {
                keyStore.load(keyStoreData, oldPassword);
            }

            // Store the keystore with the new password
            try (OutputStream output = new FileOutputStream(keyStoreFileName)) {
                keyStore.store(output, newPassword);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}