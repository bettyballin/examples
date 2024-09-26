import java.nio.file.Path;
import java.nio.file.Paths;

public class Temp3245 {
    public static void main(String[] args) {
        Path serverKeyStore = Paths.get("/path/to/keystore.jks");
        System.setProperty("javax.net.ssl.trustStore", serverKeyStore.toAbsolutePath().toString());
        System.setProperty("javax.net.ssl.trustStorePassword", "password");
        System.setProperty("javax.net.ssl.trustStoreType", "jks");
    }
}