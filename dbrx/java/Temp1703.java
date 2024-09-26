import java.util.Collections;

public class Temp1703 {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.setAllowedOrigins(Collections.singletonList("*"));
    }
}

class Configuration {
    private java.util.List<String> allowedOrigins;

    public void setAllowedOrigins(java.util.List<String> allowedOrigins) {
        this.allowedOrigins = allowedOrigins;
    }

    public java.util.List<String> getAllowedOrigins() {
        return allowedOrigins;
    }
}