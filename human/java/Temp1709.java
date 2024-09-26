import java.security.Provider;
import java.security.Security;
import java.util.Map;

public class Temp1709 {
    public static void main(String[] args) {
        for(Provider p : Security.getProviders()) {
            System.out.println("Provider " + p.getName());
            for(Map.Entry<Object, Object> e : p.entrySet()) {
                System.out.println("    " + e.getKey() + " : " + e.getValue());
            }
        }
    }
}