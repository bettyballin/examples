import java.security.Provider;
import java.security.Security;

public class ProviderInfoPrinter {
    public static void main(String[] args) {
        for (Provider provider : Security.getProviders()) {
            System.out.println(provider);
            for (Provider.Service service : provider.getServices()) {
                System.out.println("  " + service.getType() + " " + service.getAlgorithm());
            }
        }
    }
}