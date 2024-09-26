import java.security.Provider;
import java.security.Security;

public class ProviderLister {
    public static void main(String[] args) {
        for (Provider provider : Security.getProviders()) {
            System.out.println(provider.getName());
        }
    }
}