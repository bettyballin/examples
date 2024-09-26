// Example configuration class
class Config {
    private boolean secureCookie;

    public Config(boolean secureCookie) {
        this.secureCookie = secureCookie;
    }

    public boolean isSecureCookie() {
        return secureCookie;
    }
}

// Usage of the configuration class
public class CookieManager {
    public static void main(String[] args) {
        Config config = new Config(true); // Set this based on your configuration

        // Set cookie parameters
        String name = "sessionToken";
        String value = "abc123";
        boolean secure = config.isSecureCookie();
        // ...
        // Further code to set the cookie based on the parameters
    }
}