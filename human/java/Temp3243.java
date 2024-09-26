import static software.amazon.awssdk.utils.JavaSystemSetting.SSL_KEY_STORE;
import static software.amazon.awssdk.utils.JavaSystemSetting.SSL_KEY_STORE_PASSWORD;
import static software.amazon.awssdk.utils.JavaSystemSetting.SSL_KEY_STORE_TYPE;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Temp3243 {
    public static void main(String[] args) {
        // Replace with the actual path to your keystore file
        Path clientKeyStore = Paths.get("path/to/your/keystore/file");

        System.setProperty(SSL_KEY_STORE.property(), clientKeyStore.toAbsolutePath().toString());
        System.setProperty(SSL_KEY_STORE_TYPE.property(), "pkcs12");
        System.setProperty(SSL_KEY_STORE_PASSWORD.property(), "password");

        // Your additional code here...
    }
}