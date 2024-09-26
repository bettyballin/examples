import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.security.KeyStore;

public class Main {
    public static void main(String[] args) throws Exception {
        char[] password = getPassword();
        KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
        FileInputStream fis = new FileInputStream("myJks");
        ks.load(fis, password);
        // ... use the keystore
    }

    private static char[] getPassword() {
        String pathToPasswordFile = "/path/to/password/file";
        try (BufferedReader reader = new BufferedReader(new FileReader(pathToPasswordFile))) {
            return reader.readLine().toCharArray();
        } catch (IOException e) {
            throw new RuntimeException("Unable to read password from file", e);
        }
    }
}