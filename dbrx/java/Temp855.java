import java.io.File;

public class Temp855 {
    public static void main(String[] args) {
        String trustStore = System.getProperty("javax.net.ssl.trustStore");
        if (trustStore != null) {
            File keyStoreFile = new File(trustStore);
            if (keyStoreFile.exists()) {
                // The specified keystore file exists so it is being used.
                System.out.println("Keystore file exists: " + keyStoreFile.getAbsolutePath());
            } else {
                System.out.println("Keystore file does not exist.");
            }
        } else {
            System.out.println("TrustStore property is not set.");
        }
    }
}