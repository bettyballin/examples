import java.security.Provider;
import java.security.Security;
import java.util.Map;

public class SecurityProviders {
    public static void main(String[] args) {
        for (Provider provider : Security.getProviders()) {
            System.out.println(provider.getName());
            for (Map.Entry<Object, Object> entry : provider.entrySet()) {
                System.out.println("\t" + entry.getKey() + ": " + entry.getValue());
            }
        }
    }
}