import java.security.Provider;
import java.security.Security;
import java.security.Provider.Service;
import java.util.Set;

public class Temp2702 {
    public static void main(String[] args) {
        Provider[] provs = Security.getProviders();
        for (Provider prov : provs) {
            Set<Service> services = prov.getServices();
            for (Service service : services) {
                if (!service.getType().matches("(?i)Cipher")) {
                    break;
                }
                String algo = service.getAlgorithm();
                if (algo.matches("(?i).*/GCM/.*")) {
                    System.out.println(service);
                }
            }
        }
    }
}