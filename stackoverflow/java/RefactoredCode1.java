import java.security.Provider;
import java.security.Security;
import java.util.Set;

public class RefactoredCode1 {
    public static void main(String[] args) {
        Provider[] provs = Security.getProviders();
        for (Provider prov : provs) {
            Set<Provider.Service> services = prov.getServices();
            for (Provider.Service service : services) {
                if (service.getType().equalsIgnoreCase("Cipher")) {
                    String algo = service.getAlgorithm();
                    if (algo.matches("(?i).*/GCM/.*")) {
                        System.out.println(service);
                    }
                }
            }
        }
    }
}