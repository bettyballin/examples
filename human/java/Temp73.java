import java.security.KeyStore;
import java.security.Security;

public class Temp73 {
    public static void main(String[] args) {
        try {
            // Make sure to add BouncyCastleProvider for SunMSCAPI if necessary
            Security.addProvider(new sun.security.mscapi.SunMSCAPI());
            
            KeyStore msCertStore = KeyStore.getInstance("Windows-MY", "SunMSCAPI");
            msCertStore.load(null, null); // Load the keystore

            System.out.println("KeyStore type: " + msCertStore.getType());
            System.out.println("Provider: " + msCertStore.getProvider());

            // List all aliases in the keystore
            java.util.Enumeration<String> aliases = msCertStore.aliases();
            while (aliases.hasMoreElements()) {
                String alias = aliases.nextElement();
                System.out.println("Alias: " + alias);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}