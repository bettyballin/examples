import java.security.Provider;
import java.security.Security;

public class Main25 {
    public static void main(String[] args) {
        for (Provider provider : Security.getProviders()) {
            System.out.println(provider.getName());
            for (String key : provider.stringPropertyNames()) {
                if (key.toUpperCase().contains("PBKDF2")) {
                    System.out.println("\t" + key + ": " + provider.getProperty(key));
                }
            }
        }
    }
}