import java.security.Security;

public class NetworkAddressCacheConfig {
    public static void main(String[] args) {
        Security.setProperty("networkaddress.cache.ttl", "60");
        Security.setProperty("networkaddress.cache.negative.ttl", "10");
    }
}