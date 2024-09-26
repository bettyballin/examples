import java.security.SecureRandom;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.Security;

public class Temp1963 {
    public static void main(String[] args) {
        try {
            SecureRandom sr = SecureRandom.getInstance("DRBG");
            Provider provider = sr.getProvider();
            String drbgMechanism = "Unknown";
            for (Provider.Service service : provider.getServices()) {
                if ("SecureRandom".equals(service.getType()) && "DRBG".equals(service.getAlgorithm())) {
                    drbgMechanism = service.getAttribute("DrbgMechanism");
                    break;
                }
            }
            System.out.println("Using DRBG mechanism: " + drbgMechanism);
        } catch (NoSuchAlgorithmException e) {
            System.out.println("DRBG algorithm is not available.");
        }
    }
}