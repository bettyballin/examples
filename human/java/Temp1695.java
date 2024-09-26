import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.security.KeyStore;

public class Temp1695 {
    public static void main(String[] args) {
        try {
            String filename = "keystore.jks";
            char[] oldPass = "oldpassword".toCharArray();
            char[] newPassword = "newpassword".toCharArray();
            
            // Load the keystore
            InputStream keyStoreStream = new FileInputStream(filename);
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(keyStoreStream, oldPass);
            keyStoreStream.close();

            // Save the keystore with the new password
            FileOutputStream fileOutputStream = new FileOutputStream(filename);
            keyStore.store(fileOutputStream, newPassword);
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}