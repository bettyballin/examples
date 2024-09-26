import java.security.Provider;
import java.security.Security;
import java.util.Set;

public class ListAlgorithms {
    public static void main(String[] args) {
        for (Provider provider : Security.getProviders()) {
            System.out.println(provider.getName());
            Set<Object> keys = provider.keySet();
            for (Object key : keys) {
                String keyStr = (String) key;
                System.out.println("\t" + keyStr + ": " + provider.getProperty(keyStr));
            }
        }
    }
}