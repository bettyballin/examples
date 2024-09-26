import java.security.Security;
import java.util.Properties;

public class Temp1588 {
    public static void main(String[] args) {
        System.out.println(" --- runtime information --- ");
        Properties properties = System.getProperties();
        System.out.println("Properties:");
        System.out.println("    java.vendor                : " + properties.getProperty("java.vendor"));
        System.out.println("    java.specification.name    : " + properties.getProperty("java.specification.name"));
        System.out.println("    java.specification.version : " + properties.getProperty("java.specification.version"));
        System.out.println("    java.runtime.name          : " + properties.getProperty("java.runtime.name"));
        System.out.println("    java.runtime.version       : " + properties.getProperty("java.runtime.version"));
        System.out.println("    java.vm.name               : " + properties.getProperty("java.vm.name"));
        
        // Checking if unlimited crypto is available
        try {
            int maxKeyLen = javax.crypto.Cipher.getMaxAllowedKeyLength("AES");
            System.out.println("Unlimited crypto: " + (maxKeyLen > 128 ? "yes" : "no"));
        } catch (Exception e) {
            System.out.println("Unlimited crypto: no");
        }
        
        // Info for provider Bouncy Castle
        System.out.println(" --- info for provider Bouncy Castle --- ");
        
        // Adding Bouncy Castle provider
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
        
        java.security.Provider bcProvider = Security.getProvider("BC");
        if (bcProvider != null) {
            System.out.println("Bouncy Castle version: " + bcProvider.getVersion());
            System.out.println("Bouncy Castle provider registered: yes");
        } else {
            System.out.println("Bouncy Castle provider registered: no");
        }
    }
}