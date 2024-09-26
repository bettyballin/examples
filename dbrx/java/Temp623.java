import java.security.Provider;
import java.security.Security;

public class Temp623 {
    public static void main(String[] args) {
        for (Provider p : Security.getProviders()) {
            if ("com.rsa.jsafe.provider.JsafeJCE".equals(p.getName())) {
                System.out.println("BSAFE found FIPS mode is likely enabled.");
                break;
            }
        }
    }
}