import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.KeyStore;

public class Temp681 {
    public static void main(String[] args) throws Exception {
        // Load existing keystore from disk
        FileInputStream fis = new FileInputStream("mykeystore.jks");
        char[] oldPassword = "oldpassword".toCharArray();
        KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
        ks.load(fis, oldPassword);
        fis.close();

        // Change the password of an entry in the key store
        String alias = "entry1";
        char[] newPassword = "<PASSWORD>".toCharArray();

        KeyStore.PasswordProtection oldProtParam = new KeyStore.PasswordProtection(oldPassword);
        KeyStore.Entry entry = ks.getEntry(alias, oldProtParam);
        KeyStore.PasswordProtection newProtParam = new KeyStore.PasswordProtection(newPassword);
        ks.setEntry(alias, entry, newProtParam);

        // Save keystore to disk with a new password
        FileOutputStream fos = new FileOutputStream("mykeystore.jks");
        ks.store(fos, newPassword);
        fos.close();
    }
}