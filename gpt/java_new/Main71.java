import java.security.KeyPairGenerator;
import java.security.Provider;
import java.security.Security;

public class Main71 {
    public static void main(String[] args) {
        try {
            KeyPairGenerator kpg = KeyPairGenerator.getInstance("EC", "SunEC");
            Provider provider = Security.getProvider("SunEC");
            boolean hasKeyPairGeneratorService = false;
            
            for (Provider.Service service : provider.getServices()) {
                if ("KeyPairGenerator".equals(service.getType()) && "EC".equals(service.getAlgorithm())) {
                    hasKeyPairGeneratorService = true;
                    break;
                }
            }
            
            System.out.println("Provider has KeyPairGenerator service for EC: " + hasKeyPairGeneratorService);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}