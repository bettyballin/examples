import java.security.Provider;
import java.security.Security;

public class SecurityListings {
    public static void main(String[] args) {
        for (Provider provider : Security.getProviders()) {
            System.out.println("Provider: " + provider.getName());
            for (Provider.Service service : provider.getServices()) {
                System.out.println(" " + service.getType() + ": " + service.getAlgorithm());
            }
        }
    }
}